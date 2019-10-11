package DS_Java.lalala.NonLiner;

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
        add2(root, e);
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
}