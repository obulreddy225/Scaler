package com.jmp.dsa.LinkedList;

public class Reverse {
    public static Node reverseLinkedList(Node head) {

        Node prev = null;
        Node current = head;

        while (current != null) {

            Node next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }
}
