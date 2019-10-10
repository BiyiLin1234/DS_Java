package DS_Java.lalala.Queue;

import DS_Java.lalala.List.LinkedList;

//使用链表实现queue
public class LinkedListQueue<E> implements Queue<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        //构造函数
        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("can't dequeue from an empty queue");
        }
        Node resNode = head;
        head = head.next;
        resNode.next = null;//for gc
        if(head==null){
            //防止只有一个元素的时候，head都指向一个元素，此时head指向的.next是null，然而tail还是指向该元素，需要这里维护一下。
            tail = null;
        }
        size--;

        return resNode.e;
    }

    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        while(cur!=null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("null tail");
        return res.toString();
    }
    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }


}
