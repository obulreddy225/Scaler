package com.jmp.dsa.heap;

import java.util.PriorityQueue;

public class KthLargestInStream {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargestInStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    private int add(int val) {
        pq.offer(val);

        if (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}
