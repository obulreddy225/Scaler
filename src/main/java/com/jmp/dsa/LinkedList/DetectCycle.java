package com.jmp.dsa.LinkedList;

public class DetectCycle {
    public Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect whether a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Step 2: Find the starting node of the cycle
            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        // No cycle exists
        return null;
    }
}
