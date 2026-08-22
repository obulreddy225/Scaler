package com.jmp.dsa;

public class EquilibriumIndex {

    public static int bruteForceEquilibriumIndex(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }
            for (int j = i + 1; j < n; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum) {
                return i;
            }

        }
        return -1;
    }

    public static int OptimizedEquilibriumIndex(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
        int rightSum = 0;
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
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

    public static void main(String[] args) {

    }
}

