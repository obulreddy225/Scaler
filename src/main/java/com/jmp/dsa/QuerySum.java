package com.jmp.dsa;

import java.util.concurrent.LinkedBlockingDeque;

public class QuerySum {
    public static void bruteForceQuerySum(int[][] queries, int[] arr) {
        int count =1;
        for (int[] query : queries) {

            int sum =0;
            int startIndex = query[0];
            int lastIndex = query[1];
            for(int i=startIndex;i<=lastIndex;i++){
                sum+=arr[i];

            }

            System.out.println("sum of "+count+ "query is ="+sum);
            count++;
        }
    }

//    Remember the prefix-sum formula
//    For:
//        [L,R]
//    If L == 0:
//    sum = prefixSum[R]
//
//    Otherwise:
//    sum = prefixSum[R] - prefixSum[L - 1]
    public static void optimizedQuerySum(int[][] queries, int[] arr) {
        int n =arr.length;
        int count =1;
        int[] prefixSum = new int[n];
        int sum =0;
        prefixSum[0]=arr[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+arr[i];
        }
        for (int[] query:queries){
            int startIndex = query[0];
            int endIndex = query[1];
            if(startIndex==0){sum+=prefixSum[endIndex];}
            else {sum = prefixSum[endIndex]-prefixSum[startIndex-1];}
            System.out.println("sum of "+count+ "query is ="+sum);
            count++;
        }

    }
    public static void optimizedQuerySumDecreaseSpaceComplexity(int[][] queries, int[] arr) {
        int count = 1;

        // Convert arr into prefix sum array
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }

        // Answer each query
        for (int[] query : queries) {

            int startIndex = query[0];
            int endIndex = query[1];

            int sum;

            if (startIndex == 0) {
                sum = arr[endIndex];
            } else {
                sum = arr[endIndex] - arr[startIndex - 1];
            }

            System.out.println("sum of " + count + " query is = " + sum);
            count++;
        }
    }


    public static void main(String[] args) {

    }
}
