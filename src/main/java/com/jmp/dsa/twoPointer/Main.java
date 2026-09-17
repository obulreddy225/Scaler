
package com.jmp.dsa.twoPointer;

import javax.security.auth.callback.CallbackHandler;
import java.lang.management.ManagementFactory;
import java.util.*;

public class Main {
    //10. Merge Two Sorted Arrays (With Extra Space)
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] result = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else
                result[k++] = arr2[j++];
        }
        while (i < m) {
            result[k++] = arr1[i++];
        }
        while (j < n) {
            result[k++] = arr2[j++];
        }
        return result;
    }

    //9. sort colours
    public static int[] sortColours(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid < high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }

        return arr;
    }
    // 8.Move Zeros

    //[0,1,3,2,0,5]

    public static int[] moveZerosToRight(int[] arr) {
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] != 0) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
            }
        }
        return arr;
    }

    public static int[] moveZerosToLeft(int[] arr){
        int left = arr.length-1;
        for(int right= arr.length-1;right>=0;right--){
            if(arr[right]!=0){
                int temp = arr[right];
                arr[right]=arr[left];
                arr[left]=temp;
                left--;
            }
        }
        return arr;
    }
    //Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] arr){
        int i=0;
        for (int j=1;j<arr.length;j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        return i+1;
    }


    public static void main(String[] args) {

    }
}
