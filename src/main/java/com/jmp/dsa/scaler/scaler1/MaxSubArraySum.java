package com.jmp.dsa.scaler.scaler1;

// first check sliding windo and then check remaining approaches
public class MaxSubArraySum {

    public static int maxSubArraySumOFLengthKBruteForce(int[] arr, int k) {
        int n = arr.length;
        int si = 0;
        int ei = k - 1;
        int maxSum = 0;
        while (ei < n) {
            int sum = 0;
            for (int i = si; i <= ei; i++) {
                sum += arr[i];
            }
            maxSum = Math.max(sum, maxSum);
            si++;
            ei++;
        }

        return maxSum;
    }

    public static int maxSubArraySumOFLengthKPrefixSum(int[] arr, int k) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        int si = 0;
        int ei = k - 1;
        int maxSum = 0;
        while (ei < n) {
            int sum = 0;
            if (si == 0) {
                sum = prefixSum[ei];
            } else {
                sum = prefixSum[ei] - prefixSum[si - 1];
            }
            maxSum = Math.max(sum, maxSum);
            si++;
            ei++;
        }


        return maxSum;
    }


    public static int maxSubArraySumOFLengthK(int[] arr, int k) {
        int n = arr.length;
        int maxSum = 0;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        int si = 1;
        int ei = k;
        while (ei < n) {
            windowSum = windowSum - arr[si-1] + arr[ei];
            maxSum = Math.max(windowSum, maxSum);
            si++;
            ei++;
        }

        return maxSum;
    }
}
