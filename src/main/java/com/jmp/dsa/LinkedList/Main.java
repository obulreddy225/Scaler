package com.jmp.dsa.LinkedList;


public class Main {

    public static Node addNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int x = l1 != null ? l1.data : 0;
            int y = l2 != null ? l2.data : 0;

            int sum = x + y + carry;

            carry = sum / 10;
            int digit = sum % 10;

            current.next = new Node(digit);
            current = current.next;

            if(l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }
        }
       return dummy.next;

    }



    public static Node removeNthNodeFromLast(Node head, int n) {

        Node dummy = new Node(0);
        dummy.next = head;

        Node slow = dummy;
        Node fast = dummy;

        // Move fast N steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both pointers
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the Nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }


    public static void main(String[] args) {


    }


}
