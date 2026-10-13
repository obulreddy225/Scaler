package com.jmp.dsa.slidingwindow;

public class SumMinMax {

    public static int sumMinMax(int[] arr, int k) {
        if (arr == null || k <= 0 || k > arr.length) {
            return 0;
        }

        int sum = 0;

        for (int i = 0; i <= arr.length - k; i++) {
            int min = arr[i];
            int max = arr[i];

            for (int j = i; j < i + k; j++) {
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);
            }

            sum += min + max;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        int k = 4;

        System.out.println(sumMinMax(arr, k));
    }
}
