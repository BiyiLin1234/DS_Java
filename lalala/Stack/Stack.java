package DS_Java.lalala.Stack;

public interface Stack<E> {
    //获取大小
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peak();
}