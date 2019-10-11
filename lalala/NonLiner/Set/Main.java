package DS_Java.lalala.NonLiner.Set;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("pride and prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("F:/pride-and-prejudice.txt",words1)) {
            System.out.println("total words: " + words1.size());
            LinkedListSet<String> set1 = new LinkedListSet<>();
            for(String word : words1) {
                set1.add(word);
            }
            System.out.println("total unique words: " + set1.getSize());
        }
        ArrayList<String> words2 = new ArrayList<>();
        System.out.println("a tail of two cities");
        if(FileOperation.readFile("F:/a-tale-of-two-cities.txt",words2)) {
            System.out.println("total words: " + words1.size());
            LinkedListSet<String> set1 = new LinkedListSet<>();
            for(String word : words2) {
                set1.add(word);
            }
            System.out.println("total unique words: " + set1.getSize());
        }
    }
}
