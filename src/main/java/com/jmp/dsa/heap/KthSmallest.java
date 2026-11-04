package com.jmp.dsa.heap;

import java.util.PriorityQueue;

public class KthSmallest {
    public static int findKthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            pq.offer(num);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.peek();
    }


    public static void main(String[] args) {

        int[] arr = {7, 10, 4, 3, 20, 15};

        int k = 3;

        System.out.println(findKthSmallest(arr, k));
    }
}
