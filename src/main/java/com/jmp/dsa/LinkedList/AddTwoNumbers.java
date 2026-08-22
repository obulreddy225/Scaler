package com.jmp.dsa.LinkedList;

public class AddTwoNumbers {
    public static Node addTwoNumbers(Node l1, Node l2) {

        Node dummy = new Node(0);
        Node current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int x = (l1 != null) ? l1.data : 0;
            int y = (l2 != null) ? l2.data : 0;

            int sum = x + y + carry;

            carry = sum / 10;
            int digit = sum % 10;

            current.next = new Node(digit);
            current = current.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        // l1 = 2 → 4 → 3
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        // l2 = 5 → 6 → 4
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        Node result = addTwoNumbers(l1, l2);

        // Print result
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
