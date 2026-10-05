package com.jmp.dsa.scaler.scaler1;

public class RangeQuery {


    public static void rangeSum(int[][] queries, int[] arr) {
        int n = arr.length;
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += arr[i];
            }
            System.out.println(sum);

        }
    }

    public static void rangeSumOptimized(int[][] queries, int[] arr){
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0]=arr[0];
        for(int i=1;i<n;i++){
            prefix[i]= prefix[i-1]+arr[i];
        }
        for(int[] query :queries){
            int sum =0;
            int left = query[0];
            int right =query[1];
            if(left==0){
                sum = prefix[right];
            }else {
                sum = prefix[right]-prefix[left-1];
            }
            System.out.println(sum);
        }
    }
}
