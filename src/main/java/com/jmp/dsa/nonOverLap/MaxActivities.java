package com.jmp.dsa.nonOverLap;

import java.util.Arrays;

public class MaxActivities {
    public static int maxActivities(int[] start, int[] finish) {
        int n = start.length;

        // Store activity index
        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        // Sort activities based on finish time
        Arrays.sort(index, (a, b) -> finish[a] - finish[b]);

        int count = 1;
        int lastFinish = finish[index[0]];

        // Select non-overlapping activities
        for (int i = 1; i < n; i++) {
            int current = index[i];

            if (start[current] > lastFinish) {
                count++;
                lastFinish = finish[current];
            }
        }

        return count;
    }
}
