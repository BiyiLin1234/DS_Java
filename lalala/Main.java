package DS_Java.lalala;

import DS_Java.lalala.List.LinkedList;
import DS_Java.lalala.Stack.ArrayStack;
import DS_Java.lalala.Stack.LinkedListStack;
import DS_Java.lalala.Stack.Stack;

import java.util.Random;

//总测试类
public class Main {

    public static double testStak(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1_000_000_000.0;
    }
    public static void main(String[] args) {
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int i = 0; i < 5; i++) {
//            linkedList.addFirst(i);
//            System.out.println(linkedList);
//        }
//        linkedList.add(3,666);
//        System.out.println(linkedList);
//        linkedList.add(linkedList.getSize(),2333);
//        System.out.println(linkedList);
//        linkedList.remove(2);
//        System.out.println(linkedList);
//        linkedList.removeFirst();
//        System.out.println(linkedList);
//        linkedList.removeLast();
//        System.out.println(linkedList);
        int opCount = 10_000_000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStak(arrayStack,opCount);
        System.out.println("ArrayStack, time:" + time1 + "s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStak(linkedListStack,opCount);
        System.out.println("LinkedListStack, time:" + time2 + "s");
        //LinkedList的new也耗时，这个比较不好说。
    }
}
