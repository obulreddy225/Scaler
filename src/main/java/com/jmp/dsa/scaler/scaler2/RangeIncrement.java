package com.jmp.dsa.scaler.scaler2;

public class RangeIncrement {

    public static int[] rangeIncrementQueries(int[][] queries, int[] arr){
        for (int[] query:queries){
            int n =arr.length;
            int index = query[0];
            int value = query[1];

            for(int i =index;i<n;i++){
                arr[i]+=value;
            }
        }

        return arr;
    }

    public static int[] rangeIncrementQueriesOptimized(int[][] queries, int[] arr){
        for (int[] query:queries){
            int n =arr.length;
            int index = query[0];
            int value = query[1];
            arr[index]+=value;
        }
        for(int i=1;i<arr.length;i++){
            arr[i]=arr[i-1]+arr[i];
        }

        return arr;


    }
}
