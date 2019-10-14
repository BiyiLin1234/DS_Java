package DS_Java.lalala.NonLiner.MaxHeap;

import java.util.Random;

public class Main {
    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.currentTimeMillis();
        MaxHeap<Integer> maxHeap;
        if(isHeapify)
            //使用heapify方式创建堆
            maxHeap = new MaxHeap<>(testData);
        else {
            //使用一个一个添加的方式创建堆
            maxHeap = new MaxHeap<>();
            for (int num:testData) {
                maxHeap.add(num);
            }
        }
        int n = testData.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if(arr[i-1] < arr[i]) {
                throw new IllegalArgumentException("error");
            }
        }
        long stopTime = System.currentTimeMillis();
        return (stopTime - startTime) / 1000.0;
    }
    public static void main(String[] args) {

        int n = 1000_000;
        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 =  testHeap(testData,false);
        System.out.println(time1);;
        double time2 = testHeap(testData,true);
        System.out.println(time2);
//        int n = 1_000_000;
//        MaxHeap<Integer> maxHeap = new MaxHeap<>();
//        Random random = new Random();
//        for (int i = 0; i < n; i++) {
//            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
//        }
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = maxHeap.extractMax();
//        }
//        for (int i = 1; i < n; i++) {
//            if(arr[i-1] < arr[i]) {
//                throw new IllegalArgumentException("error");
//            }
//        }
//        for (int i:arr) {
//            System.out.println(i);
//        }
    }
}
