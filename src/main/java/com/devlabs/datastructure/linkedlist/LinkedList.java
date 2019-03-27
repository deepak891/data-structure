package com.devlabs.datastructure.linkedlist;


public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> head;
    private int sizeOfList;


    @Override
    public void reverse() {
        Node<T> currentNode = this.head;
        Node<T> previousNode = null;
        Node<T> nextNode = null;

        while (currentNode !=null) {
            nextNode = currentNode.getNextNode();
            currentNode.setNextNode(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

        this.head = previousNode;

    }

    @Override
    public Node<T> getMiddleNode() {
        Node<T> fastPointer = this.head;
        Node<T> slowPointer = this.head;

        while (fastPointer.getNextNode() != null && fastPointer.getNextNode().getNextNode()!=null) {
            fastPointer = fastPointer.getNextNode().getNextNode();
            slowPointer = slowPointer.getNextNode();
        }
        return slowPointer;
    }

    @Override
    public void insert(T data) {
        ++sizeOfList;

        if(head == null){
            this.head = new Node<>(data);
        }else {
            insertDataAtBeginning(data);
        }

    }

    //O(1)
    private void insertDataAtBeginning(T data) {
        Node<T> nextNode = new Node<>(data);
        nextNode.setNextNode(head);
        this.head = nextNode;
    }

    //O(n)
    private void insertDataAtEnd(T data, Node<T> node) {

        if(node.getNextNode() != null) {
            insertDataAtEnd(data, node);
        }else {
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }
    }

    @Override
    public void remove(T data) {

        if(this.head == null) return;

        --this.sizeOfList;

        if(this.head.getData().compareTo(data) == 0) {
            this.head = this.head.getNextNode();
        }else {
            remove(data, head, head.getNextNode());
        }
    }

    private void remove(T dataToRemove, Node<T> previousNode, Node<T> actualNode) {

        while (actualNode.getNextNode() != null) {
            if(actualNode.getData().compareTo(dataToRemove) == 0) {
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }

            previousNode = actualNode;
            actualNode = actualNode.getNextNode();

        }

    }

    @Override
    public void traverseList() {

        if(this.head == null) return;

        Node<T> acutalNode = this.head;

        while ( acutalNode != null ) {
            System.out.print(acutalNode + " -> ");
            acutalNode = acutalNode.getNextNode();

        }

    }

    @Override
    public int size() {
        return this.sizeOfList;
    }
}
