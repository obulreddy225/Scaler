
package com.jmp.dsa.scaler.scaler1;

import com.jmp.dsa.scaler.Main;

public class slidingWindow {

    public static int maxSubArraySumOfLengthK(int[] arr, int k) {
        int n = arr.length;

        int windowSum = 0;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        int si = 1;
        int ei = k;

        while (ei < n) {
            windowSum += arr[ei] - arr[si - 1];
            maxSum = Math.max(windowSum, maxSum);
            si++;
            ei++;
        }

        return maxSum;
    }
}
