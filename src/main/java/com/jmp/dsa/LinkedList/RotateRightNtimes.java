package com.jmp.dsa.LinkedList;


//1. Find length + tail
//2. k = k % length
//3. Connect tail → head (make circular)
//4. Find the new tail
//5. newHead = newTail.next
//6. Break the circle
//7. Return newHead
public class RotateRightNtimes {
    public Node rotateRight(Node head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length and tail
        int length = 1;
        Node tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Avoid unnecessary rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Make the list circular
        tail.next = head;

        // Find the new tail
        int steps = length - k;

        Node newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // New head is after new tail
        Node newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }
}
