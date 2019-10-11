package DS_Java.lalala.NonLiner;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] arr = {5,3,2,4,6,8};
        /*
        *            5
        *          3   6
        *         2 4   8
        * */
        for(int num : arr) {
            bst.add(num);
        }
        bst.preOrder();
        System.out.println();
        bst.removeMin();
        bst.preOrder();
    }
}
