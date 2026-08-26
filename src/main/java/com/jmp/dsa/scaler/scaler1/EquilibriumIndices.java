
package com.jmp.dsa.scaler.scaler1;

public class EquilibriumIndices {

    public static int equilibriumIndices(int[] arr) {

        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = 0;
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }
            for (int k = i + 1; k < n; k++) {
                rightSum += arr[k];
            }
            if (leftSum == rightSum) {
                count++;
            }
        }
        return count;
    }

    public static int equilibriumIndexOptimized(int[] arr) {

        for (int i=1;i<arr.length;i++){
            arr[i]=arr[i-1]+arr[i];
        }
        int n = arr.length;
        int count =0;

        for (int i = 0; i < n; i++) {
            int leftSum =0;
            int rightSum =0;

            if(i>0){
                leftSum=arr[i-1];
            }

            rightSum =arr[n-1]-arr[i];

            if(leftSum==rightSum){
                count++;
            }
        }
        return count;
    }

    // same T.C is O(n) but different approach
    public static int equilibriumIndexOptimizedAdvanced(int[] arr) {
        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            int rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                count++;
            }

            leftSum += arr[i];
        }

        return count;
    }
}
