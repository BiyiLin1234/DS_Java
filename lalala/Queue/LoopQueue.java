package DS_Java.lalala.Queue;

//循环队列
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front, tail;
    private int size;

    @Override
    public String toString() {
        StringBuilder dataString = new StringBuilder();
        dataString.append("[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            dataString.append(data[i]);
            if ((i + 1) % data.length != tail)
                dataString.append(",");
        }
        dataString.append("]");
        return "LoopQueue{" +
                "data=" + dataString +
                ", front=" + front +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    int getCapacity() {
        return data.length - 1;
    }

    private void resize(int capacity) {
        //需要研究。之前使用front-end遍历的方法容易错，这个方法借用了size不易错。
        E[] newData = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty,can't get front");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        //错误地加了个else。。。
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;

    }


    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("can't dequeue from empty queue");
        E res = data[front];
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
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