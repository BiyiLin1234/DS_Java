package DS_Java.lalala.NonLiner.map;

import DS_Java.lalala.NonLiner.Set.FileOperation;

import java.util.ArrayList;

public class LinkedListMap<K,V>  implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node next;
        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key){this(key,null,null);}
        public Node(){this(null,null,null);}
        @Override
        public String toString() {return key.toString()+":" + value.toString();}
    }
    private Node dummyHead;
    private int size;
    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }
    //根据key返回Node
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while(cur!=null) {
            if(cur.key.equals(key))
                return cur;
            cur=cur.next;
        }
        return null;
    }
    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node==null){
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }
        else {
            node.value = value;//更新了
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next==null) {
            if(prev.next.key.equals(key))
                break;
            prev= prev.next;
        }
        if(prev.next!=null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next =null;
            size--;
            return  delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key)!=null;
    }

    @Override
    public V get(K key) {
        Node node=getNode(key);
        return node==null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if(node==null)
            throw new IllegalArgumentException(key + " doesn't exist");
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

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        LinkedListMap<String ,Integer> map = new LinkedListMap<>();
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
        }
    }
}
