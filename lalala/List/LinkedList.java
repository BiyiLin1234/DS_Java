package DS_Java.lalala.List;

public class LinkedList<E> {
    //内部节点类
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

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

    //
    private Node dummyHead;//虚拟头节点，为了编程时候的方便。
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    //获取链表中元素的个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //再链表头添加新元素e
    public void addFirst(E e) {
        add(0,e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed, illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < (index); i++) {
            //找到要插入位置的前一个元素。
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);//三合一
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

}