package com.jmp.dsa.twoPointer;

public class ContainerSum {

    public static int containerProblem(int[] arr){
        int left =0;
        int right =arr.length-1;
        int maxStorage = 0;
        while (left<right){
            int width = right-left;
            int height = Math.min(arr[left],arr[right]);
            int area = width*height;
            maxStorage= Math.max(maxStorage,area);
            if(arr[left]<arr[right]){
                left++;
            }else right--;
        }
        return maxStorage;
    }
}
