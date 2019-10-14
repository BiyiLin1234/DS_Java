package DS_Java.lalala.AVL;

import DS_Java.lalala.NonLiner.MaxHeap.Array;
import DS_Java.lalala.NonLiner.Set.FileOperation;

import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>, V> {
    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public int height;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left=right=null;
            height = 1;
        }
    }
    //根结点
    private Node root;
    //目前容量
    private int size;
    public AVLTree() {
        root = null;
        size = 0;
    }
    public int getSize(){return size;}
    public boolean isEmpty() { return size == 0;}
    public int getHeight(Node node) { if(node == null) return 0; return node.height;}
    //获取平衡因子
    private int getBalanceFactor(Node node) {
        if(node == null) {
            return 0;
        }
        //left tree height - right tree height;
        return getHeight(node.left) - getHeight(node.right);
    }
    public void add(K key, V value) {
        root = add(root,key,value);
    }
    //向node为根的二分搜索树插入元素（key，value），递归算法
    //返回插入新节点后的二分搜索树的根
    private Node add(Node node, K key, V value) {
        if(node == null) {
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key) < 0) {
            //要插入的key小，放左边
            node.left = add(node.left,key,value);
        } else if(key.compareTo(node.key)>0) {
            //要插入的key大，放右边
            node.right = add(node.right,key,value);
        } else {
            //相等，那就是更新了
            node.value = value;
        }
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));
        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor)>1) {
            //System.out.println("unbalanced: " + balanceFactor);
        }
        return node;
    }
    //通过key找寻相应的Node，如果找不到返回null
    private Node getNode(Node node, K key) {
        if(node==null)
            return null;
        if(key.equals(node.key))
            return node;
        //比当前节点的值小，在左子树中找。
        else if(key.compareTo(node.key) < 0){
            return getNode(node.left,key);
        }
        else {
            return getNode(node.right,key);
        }
    }
    private boolean contains(K key) {
        return getNode(root,key) != null;//返回不等于null说明找到了，返回true
    }
    private V get(K key) {
        Node node = getNode(root,key);
        return node == null ? null : node.value;
    }
    public void set(K key, V value) {
        Node node = getNode(root,key);
        if(node==null)
            throw new IllegalArgumentException("set failed, key not found. KEY: " + key);
        node.value = value;
    }
    private Node minimum(Node node) {
        if(node.left==null)
            return node;
        else
            return minimum(node.left);
    }
    //返回以node为根的二分搜索树中最小的结点
    //返回删除后新的二分搜索树的根。
    private Node removeMin(Node node) {
        if(node.left==null) {
            //左子树为空，说明node本身最小。新根为其右结点
            Node rightNode = node.right;
            node.right = null;//for gc
            size--;
            return rightNode;
        }
        //否则递归实现，删除该节点左子树的最小节点即可。返回来的根作为该结点的左根
        node.left = removeMin(node.left);
        return node;
    }
    public V remove(K key) {
        Node node = getNode(root,key);
        if(node!=null) {
            //移除之后，返回新的根结点。
            root = remove(root,key);
            return node.value;
        }
        return null;
    }
    private Node remove(Node node, K key) {
        if(node == null) {
            return null;
        }
        if(key.compareTo(node.key) < 0) {
            node.left = remove(node.left,key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right,key);
            return node;
        } else {
            //找到了
            if(node.left==null) {
                //待删除的结点，左子树为空
                Node rightNode = node.right;
                node.right=null;//for gc
                size--;
                return rightNode;
            }
            if(node.right==null) {
                //待删除的结点右子树为空
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            else {
                //左右都不为空
                //找到比待删除结点大的最小结点。(即右子树中的最小节点)
                //作为新的根节点。
                Node successor =minimum(node.right);//successor即是比待删除结点大的最小节点
                successor.right = removeMin(node.right);//首先将他删除，并将右子树删除最小值后的树的根节点返回。最为继承者的右结点。
                successor.left = node.left;//左节点照搬集成。

                node.left = node.right = null;//for gc
                return successor;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("pride and prejudice");
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("E:/txt/pride-and-prejudice.txt",words)) {
            System.out.println("total words" + words.size());
            AVLTree<String,Integer> map = new AVLTree<>();
            for(String word : words) {
                if(map.contains(word)){
                    map.set(word,map.get(word) + 1);
                } else {
                    map.add(word,1);
                }
            }
            System.out.println("total different words: "+ map.getSize());
            System.out.println("frequency of pride " + map.get("pride"));
            System.out.println("frequency of what " + map.get("what"));
            System.out.println("frequency of but " + map.get("but"));
            System.out.println("frequency of love " + map.get("love"));
            System.out.println("frequency of like " + map.get("like"));
            System.out.println("frequency of a " + map.get("a"));
        }
    }
}






























