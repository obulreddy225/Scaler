package com.jmp.dsa.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    // Max Heap → smaller half
    private PriorityQueue<Integer> left =
            new PriorityQueue<>(Collections.reverseOrder());

    // Min Heap → larger half
    private PriorityQueue<Integer> right =
            new PriorityQueue<>();

    public MedianFinder() {
    }

    public void addNum(int num) {

        // Add to left
        left.add(num);

        // Maintain ordering:
        // every element in left <= every element in right
        if (!right.isEmpty() && left.peek() > right.peek()) {
            right.add(left.poll());
        }

        // Balance the heaps
        if (left.size() > right.size() + 1) {
            right.add(left.poll());
        }

        if (right.size() > left.size()) {
            left.add(right.poll());
        }
    }

    public double findMedian() {

        // Odd number of elements
        if (left.size() > right.size()) {
            return left.peek();
        }

        // Even number of elements
        return (left.peek() + right.peek()) / 2.0;
    }

    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();

        int[] arr = {1, 2, 3, 4, 5};

        for (int num : arr) {
            medianFinder.addNum(num);
            System.out.println(
                    "After adding " + num +
                            " → Median = " + medianFinder.findMedian()
            );
        }
    }
}