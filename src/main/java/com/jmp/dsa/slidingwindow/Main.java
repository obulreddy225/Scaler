package com.jmp.dsa.slidingwindow;

public class Main {
    //1. Maximum Sum of Subarray of Size K — Easy
    public static int maximumSum(int[] arr, int k){
        int n =arr.length;
        int windowSum =0;
        int maxSum =0;
        for(int i=0;i<k;i++){
            windowSum+=arr[i];
        }
        maxSum=windowSum;
        int si = 1; int ei= k;
        while (ei<n){
            windowSum+=arr[ei]-arr[si-1];
            maxSum =Math.max(windowSum,maxSum);

            si++;
            ei++;
        }
        return maxSum;
    }

    //2. Average of All Subarrays of Size K — Easy/Medium
    public static double[] averageOfSubarrays(int[] arr, int k) {
        int n = arr.length;
        double[] result = new double[n - k + 1];
        int windowSum = 0;
        // First window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        result[0] = (double) windowSum / k;
        // Remaining windows
        int si = 1;
        int ei = k;
        int index = 1;
        while (ei < n) {
            windowSum += arr[ei] - arr[si - 1];
            result[index] = (double) windowSum / k;
            si++;
            ei++;
            index++;
        }
        return result;
    }
}
