package DS_Java.lalala.NonLiner;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//E必须可比较大小
//本课程二分搜索树不包含重复元素。（插入元素时候，相等自动去除。）
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    //构造
    public BST() {
        root = null;
        size = 0;
    }

    //返回二叉树元素数据
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //插入节点
    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
        root = add2(root, e);
    }

    //add的第一版
    //向以node为根的二分搜索树中插入元素E，递归方法
    private void add(Node node, E e) {
        if (e.equals(node.e))
            return;
        else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        } else {
            //以上为终止条件。
            if (e.compareTo(node.e) < 0)
                add(node.left, e);
            else
                add(node.right, e);
        }
    }

    //add的第二版
    private Node add2(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add2(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add2(node.right, e);
        }
        return node;
    }

    public void preOrder() {
        preOrder(root);
    }
    //git这是哪里用的不恰当吗？？？为什么没有完全同步。。。
    private void preOrder(Node node) {
        if(node==null)
            return;
        System.out.println(node.e);
        if(node.left!=null){
            preOrder(node.left);
        }
        if(node.right!=null){
            preOrder(node.right);
        }

    }
    //non recursive 遍历二分搜索树
    public void preOrderNR() {
        //用util工具包中的栈。
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }
    //利用队列实现层次遍历
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);
            if(cur.left!=null) {
                q.add(cur.left);
            }
            if(cur.right!=null) {
                q.add(cur.right);
            }
        }
    }
    //寻找最小
    public E minium() {
        if(size==0)
            throw new IllegalArgumentException("BST is empty");
        return minium(root).e;
    }
    private Node minium(Node node) {
        if(node.left==null)
            return node;
        return minium(node.left);
    }
    //寻找最大
    public E maxmun() {
        if(size==0)
            throw new IllegalArgumentException("BST is empty");
        return maxmun(root).e;
    }
    private Node maxmun(Node node) {
        if(node.right==null)
            return node;
        return maxmun(node.right);
    }
    //删除最值。
    public E removeMin() {
        E ret = minium();
        root = removeMin(root);
        return ret;
    }
    private Node removeMin(Node node){
        if(node.left==null){
            Node rightNode = node.right;
            node.right =null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }
    //删除指定
    public void remove(E e) {
        remove(root,e);
    }
    //删除以node为根的二分搜索树中值为e的既定。
    //返回删除后新节点的根
    private Node remove(Node node, E e){
        if(node == null) {
            return null;
        }
        if(e.compareTo(node.e)<0){
            node.left = remove(node.left,e);
            return node;
        }
        else if (e.compareTo(node.e)>0){
            return node;
        }
        else {//e.equals(node.e)
            if(node.left==null){
                Node rightNode = node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            if(node.right==null){
                Node leftNode = node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            //左右均不为空，返回比删除节点大的最小节点。作为根节点
            Node successor = minium(node.right);
            successor.right = removeMin(node.right);//其中已经size--了。
            node.left=node.right=null;
            return successor;
        }
    }
}