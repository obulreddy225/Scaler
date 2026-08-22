package com.jmp.dsa.binarySearch;

public class PeakNumber {
    //3.Find Peak Element
    public static int peakNumber(int[] arr){
        int left =0;
        int right =arr.length-1;
        while (left<right){
            int mid = left+(right-left)/2;
            if(arr[mid]<arr[mid+1]){
                left =mid+1;
            }else right=mid;
        }
        return left;
    }



}
