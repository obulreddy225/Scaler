package com.jmp.dsa.heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    //Kth Largest Element in an Array
    public static int kthLargestElement(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->Integer.compare(b,a));
        for (int num: arr){
            pq.offer(num);
        }
        for (int i=0;i<k-1;i++){
            pq.poll();
        }
        return pq.peek();
    }
}
