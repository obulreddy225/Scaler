package com.jmp.dsa;

class QueueUsingArray {

    private int[] arr;
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    // OFFER - add element
    public void offer(int data) {
        if (size == arr.length) {
            throw new RuntimeException("Queue is full");
        }

        arr[rear] = data;
        rear++;
        size++;
    }

    // POLL - remove element
    public int poll() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }

        int data = arr[front];
        front++;
        size--;

        return data;
    }

    // PEEK - view front element
    public int peek() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }

        return arr[front];
    }

    // SIZE
    public int size() {
        return size;
    }
}