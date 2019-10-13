package DS_Java.lalala;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.ArrayList;
import java.util.Arrays;

//使用泛型，不能放置基本数据类型primitive <boolean byte char short int long float double>，但可使用包装类
public class Array<E> {
    private E[] data;//
    private int size;//目前存放的元素的个数。所指向的元素正好没有值。（之前都有）

    public Array(int capacity) {
        if (capacity <= 1)
            capacity = 10;
        data = (E[])new Object[capacity];//不支持泛型直接开辟空间。
        size = 0;
    }

    public Array() {
        this(10);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            res.append(get(i));
            if(i!=getSize()-1)
                res.append(",");
        }
        return "Array{" +
                "data=[" + res +
                "], size=" + size +
                '}';
    }


    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCapacity) {
        E[] data_new = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            data_new[i] = data[i];
        }
        data = data_new;
    }
    public void add(int index, E elem) {
        if (size == data.length) {
            resize(size*2);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. index illegal");
        }
        for (int i = size; i > index; --i) {
            data[i] = data[i - 1];
        }
        data[index] = elem;
        size++;
    }

    public void addLast(E elem) {
        add(size, elem);
    }

    public void addFirst(E elem) {
        add(0, elem);
    }

    public boolean contains(E elem) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }

    public int find(E elem) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("removed failed, index is illegal");
        }
        E temp = data[index];
        for (int i = index; i < size-1; ++i) {
            data[i] = data[i + 1];
        }
        size--;
        if (size == data.length/2)
            resize(data.length/2);
        return temp;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    public E get(int index) {
        if(index<0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    public E getLast() {
        return get(size-1);
    }
    public E getFirst() {
        return get(0);
    }
    //传入elem，删除数组中的elem
    public void removeElement(E elem) {
        int index = find(elem);
        if (index != -1)
            remove(index);
    }

    public static void main(String[] args) {
        //===================================================================
        /*
        //与自带的ArrayList效率对比
        int num = 100000;
        Array array = new Array(10);
        ArrayList<Integer> arrayList = new ArrayList<>();
        long startTime, endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            array.addLast(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("1:" + (endTime - startTime));
        System.out.println(array.getCapacity());

        startTime = System.currentTimeMillis();
        array = new Array(10);
        for (int i = 0; i < num; i++) {
            array.addFirst(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("2:" + (endTime - startTime));
        System.out.println(array.getCapacity());

        startTime = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            arrayList.add(num);
        }
        endTime = System.currentTimeMillis();
        System.out.println("3:" + (endTime - startTime));
        System.out.println(arrayList.size());

        startTime = System.currentTimeMillis();
        arrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            arrayList.add(0, num);
        }
        endTime = System.currentTimeMillis();
        System.out.println("4:" + (endTime - startTime));
        System.out.println(arrayList.size());
    }
    */
        //===================================================================
        Array<Integer> arr = new Array(10);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(1,100);
        System.out.println(arr);
        arr.addFirst(-1);
        System.out.println(arr);
        arr.remove(2);
        System.out.println(arr);
        arr.removeElement(4);
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);
    }
}
