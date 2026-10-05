package com.jmp.dsa.scaler.scaler5;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {


    public static int[][] insert(int[][] arr, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();

        int n = arr.length;
        int L = newInterval[0];
        int R = newInterval[1];

        int i = 0;

        while (i < n) {

            // 1. Existing interval is completely before newInterval
            if (arr[i][1] < L) {
                ans.add(new int[]{arr[i][0], arr[i][1]});
                i++;
            }

            // 2. Existing interval is completely after newInterval
            else if (R < arr[i][0]) {
                ans.add(new int[]{L, R});

                // Add all remaining intervals
                while (i < n) {
                    ans.add(new int[]{arr[i][0], arr[i][1]});
                    i++;
                }

                return ans.toArray(new int[ans.size()][]);
            }

            // 3. Existing interval overlaps with newInterval
            else {
                L = Math.min(L, arr[i][0]);
                R = Math.max(R, arr[i][1]);
                i++;
            }
        }

        // Add newInterval / merged interval
        ans.add(new int[]{L, R});

        return ans.toArray(new int[ans.size()][]);
    }




}
