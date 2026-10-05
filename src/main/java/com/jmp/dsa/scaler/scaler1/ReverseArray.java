package com.jmp.dsa.scaler.scaler1;

public class ReverseArray {

    public static int[] reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }

    public static int[] reverseSubArray(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }

    // [1,2,3,4,5]

    public static int[] shiftRight(int[] arr, int k) {
        int n = arr.length;

        k = k % n;

        // Full array
        reverseSubArray(arr, 0, n - 1);

        // First k elements
        reverseSubArray(arr, 0, k - 1);

        // Remaining elements
        reverseSubArray(arr, k, n - 1);

        return arr;
    }

    public static int[] shiftLeft(int[] arr, int k) {
        int n = arr.length;

        k = k % n;

        // First half
        reverseSubArray(arr, 0, k - 1);

        // Second half
        reverseSubArray(arr, k, n - 1);

        // Entire array
        reverseSubArray(arr, 0, n - 1);

        return arr;
    }
}
