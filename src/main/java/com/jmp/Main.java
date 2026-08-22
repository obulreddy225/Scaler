package com.jmp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    //Input:
    //nums = [2, 7, 11, 15]
    //target = 9
    //
    //Output:
    //[0, 1]
    public static int[] sum(int[] arr, int target){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int needed = target-arr[i];
            if(map.containsKey(needed)){
                return new int[]{map.get(needed), i};
            }
            map.put(arr[i],i);
        }
        return new int[] {-1,-1};
    }

    //Binary array contains all 0s and 1s, move all zeroes to left.
    public static int[] moveZerosToLeft(int[] arr){
        int n =arr.length;
        int left = arr.length-1;
        for(int right=arr.length-1;right>=0;right++){
            if(arr[right]!=0){
                int temp =arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                left--;
            }

        }
        return arr;
    }
    //Input:
    //arr = [1, 2, 2, 3, 4, 4, 5]
    //
    //Output:
    //[1, 2, 3, 4, 5]
    public static int[] remove(int[] arr){
        int i=0;

        for(int j=1;j<arr.length;j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        int length = i+1;

        int[] unique = new int[length];
        for(int k=0;k<length;k++){
            unique[k]=arr[k];

        }
        return unique;
    }

    //1 to 100 are inserted in a list in any order with one number missing. Write a program to find it
    public static int missingNumber(int[] arr){
        Arrays.sort(arr);
        int left =0;
        int right =arr.length-1;

        while (left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]==mid+1){
                left=mid+1;
            }else right=mid-1;
        }
        return left;
    }

}
