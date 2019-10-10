package DS_Java.lalala.Queue;

public class Test<E> {
    private E[] data;
    public Test() {
        data = (E[]) new Object[10];
    }
    public void  addData(E e) {
        data[0] = e;
    }
}
