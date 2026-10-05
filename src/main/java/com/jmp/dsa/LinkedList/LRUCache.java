package com.jmp.dsa.LinkedList;


import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;

    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Recently used → move to tail
        remove(node);
        addToTail(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {
            Node node = map.get(key);

            node.value = value;

            remove(node);
            addToTail(node);

            return;
        }

        // Create new node
        Node node = new Node(key, value);

        map.put(key, node);
        addToTail(node);

        // Capacity exceeded
        if (map.size() > capacity) {

            Node lru = head.next;

            remove(lru);
            map.remove(lru.key);
        }
    }

    private void remove(Node node) {
        //head<->[A]<->[B]<->[c]<->tail
        //if we want remove b then we need to connect the A and C
        //B.prev = A and B.next =c;
        //So. Node.prev.next = node.next;
        node.prev.next = node.next;

        // in above we had connected A->C and now need to connect C->A
        // Node.next.prev = node .prev
        node.next.prev = node.prev;
    }


    private void addToTail(Node node) {
        // head<->[A]<->tail -- want to insert B Node where after A before tail
        //so B.prev = A and tail. prev =A, SO Node.prev = tail.prev

        //we need to insert new node  before tail so Node.next = tail
        node.prev = tail.prev;
        node.next = tail;
        //we need to tell existing node your next node is new Node. SO, tail.previous.next = node;
        //and also tail .preveious = node

        tail.prev.next = node;
        tail.prev = node;
    }
}

