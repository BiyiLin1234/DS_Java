package DS_Java.lalala.NonLiner.Set;

import DS_Java.lalala.List.LinkedList;
import DS_Java.lalala.NonLiner.Set.setInterface.Set;

public class LinkedListSet<E> implements Set<E> {
    private LinkedList list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if(!list.contains(e))
            list.addFirst(e);
    }

    @Override
    public void remove(E e) {
//        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
