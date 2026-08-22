package com.jmp.dsa.twoPointer;

public class MoveZeroes {

    public static int[] moveZerosToEnd(int[] arr) {
        int n = arr.length;
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }
        while (index < n) {
            arr[index] = 0;
            index++;
        }
        return arr;
    }

    public static int[] moveZerosToStart(int[] arr) {
        int n = arr.length;
        int index = arr.length-1;

        for(int i=arr.length-1;i>=0;i--){
           if(arr[i]!=0){
               arr[index]=arr[i];
               index--;
           }
        }
        while (index>=0){
            arr[index]=0;
            index--;
        }
        return arr;
    }

    public static int moveZerosToEndUsing2Pointer(int[] arr){
        int left =0;
        int n = arr.length;
        for(int right =0;right<n;right++){
            if(arr[right]!=0){
                int temp =arr[right];
                arr[right]=arr[left];
                arr[left]=temp;
                left++;
            }
        }
        return left;
    }
    public static int[] moveZerosToStartUsing2Pointer(int[] arr){
        int left =arr.length-1;
        int n = arr.length;
        for(int right =arr.length-1;right>=0;right--){
            if(arr[right]!=0){
                int temp =arr[right];
                arr[right]=arr[left];
                arr[left]=temp;
                left--;
            }
        }
        return arr;
    }


}
