package com.jmp.dsa.scaler.scaler1;

public class sumOfAllSubArraySu {

    public static int sumOfAllSubArraySum(int[] arr) {
        int n = arr.length;
        int sumOfAllSubArraySum = 0;

        for (int si = 0; si < n; si++) {
            for (int ei = si; ei < n; ei++) {
                int sum = 0;
                for (int i = si; i <= ei; i++) {
                    sum += arr[i];
                }
                sumOfAllSubArraySum+=sum;

            }

        }
        return sumOfAllSubArraySum;
    }

    public static  long sumOfAllSubArray(int[] arr){
        int n =arr.length;
        int totalSum =0;
        for (int si = 0; si < n; si++) {
            int sum = 0;

            for (int ei = si; ei < n; ei++) {
                sum += arr[ei];
                totalSum += sum;
            }
        }
        return totalSum;
    }

    public static long sumOfAllSubArraySumOptimized(int[] arr) {
        int n = arr.length;
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += (long) arr[i] * (i + 1) * (n - i);
        }

        return totalSum;
    }
}
