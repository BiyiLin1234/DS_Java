package DS_Java.lalala.NonLiner.MaxHeap;

//最大堆
public class MaxHeap<E extends Comparable<E>> {
    //自己定义的动态数组，相当于vector
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树中某索引对应的父结点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent");
        return (index - 1) / 2;
    }

    //返回左子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回右子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    //添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    //取出堆中的最大元素，（删除堆顶元素，然后将最后一个元素放到堆顶，然后sift down）
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            //说明有左子树
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                //看看右子树是否最大。是的话和右子树交换
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("cann't findMax when heap is empty");
        }
        return data.get(0);
    }

    //取出最大的元素，并替换成元素e
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
    //heapify : 将任何数组整理成堆.
    //只需从最后一个非叶子结点之前所有结点进行heapify操作
    //直接写成构造函数，用户传入数组，然后heapify
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for(int i = (arr.length-1);i>=0;i--) {
            siftDown(i);
        }
    }
}
