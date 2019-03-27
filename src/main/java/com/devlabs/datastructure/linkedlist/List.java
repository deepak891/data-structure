package com.devlabs.datastructure.linkedlist;

public interface List<T extends Comparable> {

    public void reverse();

    public Node getMiddleNode();

    public void insert(T data);

    public void remove(T data);

    public void traverseList();

    public int size();

}
