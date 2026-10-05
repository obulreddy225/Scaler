package com.jmp.dsa.scaler.scaler5;

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

            // Next start <= current/merged end
            if (intervals[i][0] <= end) {

                // Merge
                end = Math.max(end, intervals[i][1]);

            } else {

                // No overlap → store previous interval
                result.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add the last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }


    public static void mergeIntervals(int[] s, int[] e) {

        int n = s.length;

        // Sort intervals by start time
        Integer[] index = new Integer[n];

        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> s[a] - s[b]);

        int L = s[index[0]];
        int R = e[index[0]];

        for (int i = 1; i < n; i++) {

            int start = s[index[i]];
            int end = e[index[i]];

            if (start <= R) {
                // Overlap
                R = Math.max(R, end);
            } else {
                // No overlap
                System.out.println(L + " " + R);

                L = start;
                R = end;
            }
        }

        // Print the last interval
        System.out.println(L + " " + R);
    }

    public static void main(String[] args) {

        int[] s = {1, 2, 8, 9};
        int[] e = {3, 6, 10, 12};

        mergeIntervals(s, e);
    }
}