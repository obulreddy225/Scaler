package com.jmp.dsa.scaler.scaler1;

public class EquilibriumIndex {
    public static int equilibriumIndex(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

            int rightSum = 0;
            for (int j = i + 1; j < n; j++) {
                rightSum += arr[j];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }

    public static int equilibriumIndexOptimized(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        for (int i = 0; i < n; i++) {
            int leftSum = 0;
            int rigthSum = 0;
            if(i==0){
                leftSum=0;
            }else {
                leftSum = prefix[i-1];
            }
            rigthSum = prefix[n - 1] - prefix[i];
            if (leftSum == rigthSum) {
                return i;
            }
        }
        return -1;
    }

}
