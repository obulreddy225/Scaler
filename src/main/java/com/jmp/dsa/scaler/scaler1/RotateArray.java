package com.jmp.dsa.scaler.scaler1;

public class RotateArray {

    //1,2,3,4,5
    //4,5,1,2,3

    //RIGHT ROTATION = ALL → FIRST → REST.
    public static int[] rotateArrayByRight(int[] arr, int k) {
        int n = arr.length;

        k = k % n;

        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
        return arr;
    }

    //FIRST → REST → ALL
    public static int[] rotateArrayByLeft(int[] arr, int k){
        int n =arr.length;
        k=k%n;

        reverseArray(arr,0,k-1);
        reverseArray(arr,k,n-1);
        reverseArray(arr,0,n-1);


        return arr;
    }

    public static int[] reverseArray(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        return arr;
    }
}
