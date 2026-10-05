package com.jmp.dsa.scaler.scaler1.assignments;

public class RangeSum {
    public static int[] rangeSum(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefix = new int[n];
        int[] response = new int[queries.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            if (left == 0) {
                response[i] = prefix[right];
            } else
                response[i] = prefix[right] - prefix[left - 1];

        }

        return response;
    }

    public static int equilibriumIndex(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
        for (int i = 0; i < n; i++) {
            int leftSum = 0;
            int rightSum = 0;
            if (i == 0) {
                leftSum = 0;
            } else {
                leftSum = arr[i - 1];
            }
            rightSum = arr[n - 1] - arr[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public static int subArraySum(int[] arr) {
        int answer = 0;
        for (int si = 0; si < arr.length; si++) {
            int sum = 0;
            for (int ei = si; ei < arr.length; ei++) {
                sum += arr[ei];
                answer += sum;
            }

        }
        return answer;
    }

    //Given an integer array A of size N and an integer B,
    // you have to return the same array after rotating it B times towards the right.
    public static int[] rightShift(int[] arr, int k) {
        int n=arr.length;
        k = k % n;
        rotateSubArray(arr, 0, n - 1);
        rotateSubArray(arr, 0, k - 1);
        rotateSubArray(arr, k, n - 1);
        return arr;
    }

    public static int[] rotateSubArray(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }
}
