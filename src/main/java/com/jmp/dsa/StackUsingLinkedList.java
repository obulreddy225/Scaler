package com.jmp.dsa;

class StackUsingLinkedList {

    private Node top;
    private int size;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // PUSH
    public void push(int data) {
        Node newNode = new Node(data);

        newNode.next = top;
        top = newNode;

        size++;
    }

    // POP
    public int pop() {
        if (top == null) {
            throw new RuntimeException("Stack is empty");
        }

        int data = top.data;
        top = top.next;

        size--;

        return data;
    }

    // PEEK
    public int peek() {
        if (top == null) {
            throw new RuntimeException("Stack is empty");
        }

        return top.data;
    }

    // SIZE
    public int size() {
        return size;
    }
}