package com.jmp.dsa.heap;

import java.util.PriorityQueue;

public class KthSmallest {
    public static int findKthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all elements to Min Heap
        for (int num : arr) {
            minHeap.add(num);
        }

        // Remove k - 1 smallest elements
        for (int i = 1; i < k; i++) {
            minHeap.poll();
        }

        // kth smallest element
        return minHeap.peek();
    }

    public static void main(String[] args) {

        int[] arr = {7, 10, 4, 3, 20, 15};

        int k = 3;

        System.out.println(findKthSmallest(arr, k));
    }
}
