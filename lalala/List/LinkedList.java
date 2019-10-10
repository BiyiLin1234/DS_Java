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

    //
    private Node dummyHead;//虚拟头节点，为了编程时候的方便。本身不存储数据。
    private int size;//链表中元素大小

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

    //添加元素
    public void add(int index, E e) {
        //index下标从0开始。
        if (index < 0 || index > size) {
            //比如存放了三个数据，size为3，index分别为0，1，2。此时add到3是允许的，能够找到3的前驱节点
            //                此时，合法index范围0，1，2，3。
            throw new IllegalArgumentException("add failed, illegal index.");
        }
        Node prev = dummyHead;//虚拟头节点
        for (int i = 0; i < (index); i++) {
            //找到要插入位置的前一个元素。假设要插入的元素index==3,需要找到的prev node的index==2。
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);//三合一，因为赋值语句会先调用运行后面的语句。
        size++;
    }

    //再链表头添加新元素e
    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    //获取值
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, illegal index");
        }
        Node cur = dummyHead.next;//从第一个有值的结点开始，向后查找index次。
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    //修改值
    public void set(int index, E e) {
        if(index<0 || index>=size)
            throw new IllegalArgumentException("index illegal, set failed.");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //查找值
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    //删除元素
    public E remove(int index) {
        if(index<0 || index>=size) {
            throw new IllegalArgumentException("index illegal, delete failed.");
        }

/*
        //这种遍历方法在index==0的情况下出现错误。找前驱不熟
        Node prev = dummyHead.next;
        for (int i = 0; i < (index - 1); i++) {
            //找到需要删除的结点的前一个结点。
            prev = prev.next;
        }*/
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node resNode  = prev.next;
        prev.next = prev.next.next;
        resNode.next = null;//for gc
        size--;
        return resNode.e;
    }
    public E removeFirst() { return remove(0); }
    public E removeLast() { return remove(size-1);}
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        res.append("[");
        //另一种遍历方法。
        while(cur!=null) {
            res.append(cur + "->");
            cur= cur.next;
        }
        res.append("null]");
        return "LinkedList{" +
                res.toString() +
                ", size=" + size +
                '}';
    }
}