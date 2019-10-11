package DS_Java.lalala.NonLiner.map;

import DS_Java.lalala.NonLiner.Set.FileOperation;
import com.sun.org.apache.xalan.internal.lib.NodeInfo;

import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V>{
    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }
    private Node add(Node node,K key, V value) {
        if(node == null){
            size++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)<0){
            node.left=add(node.left,key,value);
        } else if(key.compareTo(node.key)>0){
            node.right = add(node.right,key,value);
        } else {
            //相等
            node.value = value;
        }
        return node;
    }

    private Node getNode(Node node,K key) {
        if(node==null){
            return null;
        }
        if(key.compareTo(node.key)==0)
            return node;
        else if(key.compareTo(node.key)<0)
            return getNode(node.left,key);
        else
            return getNode(node.right,key);
    }
    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if(node!=null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }
    private Node remove(Node node,K key) {
        if(node==null)
            return null;
        if(key.compareTo(node.key)<0){
            node.left = remove(node.left,key);
            return node;
        } else if(key.compareTo(node.key)>0){
            node.right = remove(node.right,key);
            return node;
        }
        else {
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
            Node successor = minium(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left=node.right=null;
            return successor;
        }
    }
    private Node minium(Node node){
        if (node.left == null)
            return node;
        return minium(node.left);
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
    @Override
    public boolean contains(K key) {
        return getNode(root,key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root,key);
        return node==null?null:node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root,key);
        if(node==null)
            throw new IllegalArgumentException("set failed.");
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public Node(K key,  V value){
            this.key = key;
            this.value=value;
            left=null;
            right=null;
        }
    }
    private Node root;
    private int size;
    public BSTMap() {
        root = null;
        size = 0;
    }
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        BSTMap<String ,Integer> map = new BSTMap<>();
        if(FileOperation.readFile("F:/pride-and-prejudice.txt",words)){
            System.out.println("total: " +words.size());
            for(String w : words) {
                if(map.contains(w))
                    map.set(w,map.get(w)+1);
                else
                    map.add(w,1);
            }
            System.out.println("total diff: " +map.getSize());
            System.out.println("pride: " + map.get("pride"));
            System.out.println("he: "+ map.get("he"));
            System.out.println("she: "+ map.get("she"));
            System.out.println("delight: "+ map.get("delight"));
            System.out.println("love: "+ map.get("love"));
        }
    }
}
