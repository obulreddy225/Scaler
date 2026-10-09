package com.jmp.dsa.LinkedList;

public class MergeLinkedList {
    public static Node merge(Node head1, Node head2) {

        Node dummy = new Node(0);
        Node current = dummy;

        while (head1 != null && head2 != null) {

            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }

            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        }

        if (head2 != null) {
            current.next = head2;
        }

        return dummy.next;
    }
}
