package com.jmp.dsa.heap;

import java.util.PriorityQueue;

public class LastStoneWeight {

    //You are given an array of stone weights. Each turn, take the two heaviest stones and smash them together.
    //- If both stones have the same weight, both are destroyed.
    //- If the weights differ, the lighter stone is destroyed, and the heavier stone's remaining weight is the difference.
    //- Repeat until at most one stone remains.
    //Return the weight of the last stone, or 0 if no stones remain.

    public static int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        // Step 1: Add all stones
        for (int stone : stones) {
            pq.offer(stone);
        }

        // Step 2: Smash stones until at most one remains
        while (pq.size() > 1) {

            int first = pq.poll();
            int second = pq.poll();

            if (first != second) {
                pq.offer(first - second);
            }
        }

        // Step 3: Return the last stone
        return pq.isEmpty() ? 0 : pq.peek();
    }

}
