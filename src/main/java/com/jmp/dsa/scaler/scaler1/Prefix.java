package com.jmp.dsa.scaler.scaler1;

public class Prefix {

    //    You are given an integer array arr containing N elements and Q queries.
//
//    For each query, you are given two integers L and R. You need to calculate and print the sum of all
//    elements from index L to index R, both inclusive.
//
    public static void rangeSumQuery(int[][] queries, int[] arr) {

        for (int[] query : queries) {
            int leftIndex = query[0];
            int rightIndex = query[1];

            int sum = 0;
            for (int i = leftIndex; i <= rightIndex; i++) {
                sum += arr[i];
            }
            System.out.println(sum);
        }

    }

    public static void rangeSumQueryOptimized(int[][] queries, int[] arr) {
        int n =arr.length;
        for (int i=1;i<n;i++){
            arr[i]=arr[i-1]+arr[i];
        }

        for (int[] query : queries) {
            int leftIndex = query[0];
            int rightIndex = query[1];
            int sum = 0;
            if (leftIndex == 0) {
                sum = arr[rightIndex];
            } else {
                sum = arr[rightIndex] - arr[leftIndex - 1];
            }
            System.out.println(sum);

        }


    }
}
