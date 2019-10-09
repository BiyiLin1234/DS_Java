package com.lalala;

public class Student {
    private String _name;
    private int _score;

    @Override
    public String toString() {
        return "Student{" +
                "_name='" + _name + '\'' +
                ", _score=" + _score +
                '}';
    }

    public Student() {
        this("no one", -1);
    }
    public Student(String name, int socre) {
        _name = name;
        _score = socre;
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Alice",100));
        arr.addLast(new Student("Bob",3));
        arr.addLast(new Student("Luff",88));
    }
}
