package com.jmp.dsa.nonOverLap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= end) {
                // Overlap: update maximum end time
                end = Math.max(end, intervals[i][1]);
            } else {
                // No overlap: add previous interval
                result.add(new int[]{start, end});

                // Update start and end for the next interval
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add the last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}
