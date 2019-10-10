package DS_Java.lalala.Queue;

import java.util.Random;

public class Main {
    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();//纳秒
        Integer integer = 3;
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(/*random.nextInt(Integer.MAX_VALUE)*/integer);
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime-startTime) / 1_000_000_000.0;
    }

    public <E> void test() {

    }
    public static void  main(String[] args) {
        int opCount = 100_000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue,opCount);
        System.out.println("ArrayQueue, time:" + time1 + "s");


        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue,opCount);
        System.out.println("LoopQueue, time:" + time2 + "s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(loopQueue,opCount);
        System.out.println("LinkedListQueue, time:" + time3 + "s");
    }
}
