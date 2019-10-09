package com.lalala.Stack;

import com.lalala.Array;

public class ArrayStack<E> implements Stack<E>{
    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    public int getCapacity() {
        return array.getCapacity();
    }
    //返回当前大小
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public E peak() {
        return null;
    }
}
