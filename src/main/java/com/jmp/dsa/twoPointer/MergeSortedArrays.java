package com.jmp.dsa.twoPointer;

public class MergeSortedArrays {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {

        int n = arr1.length;
        int m = arr2.length;

        int[] result = new int[n + m];

        int i = 0; // pointer for arr1
        int j = 0; // pointer for arr2
        int k = 0; // pointer for result

        // Compare elements from both arrays
        while (i < n && j < m) {

            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1
        while (i < n) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2
        while (j < m) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static int[] merge(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int[] merged = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i<m&&j<n){
            if(A[i]<=B[j]){
                merged[k++]=A[i++];
            }else {
                merged[k++]=B[j++];
            }
        }
        while (i<m){
            merged[k++]=A[i++];
        }
        while (j<n){
            merged[k++]=B[j++];
        }

        return merged;
    }
}
