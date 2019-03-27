package com.devlabs.datastructure.linkedlist;

public class App {

    public static void main(String[] args) {

        List<Person> list = new LinkedList<>();
        list.insert(new Person("Ram", 10));
        list.insert(new Person("Syam", 30));
        list.insert(new Person("Akshay", 20));
        list.insert(new Person("Salman", 50));

        list.traverseList();
        System.out.println(list.size());

        System.out.println();
        list.remove(new Person("Syam", 30));

        list.traverseList();
        System.out.println(list.size());

        System.out.println(list.getMiddleNode());
    }
}
