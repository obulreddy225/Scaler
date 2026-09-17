package com.jmp.dsa.greedy;

import java.util.Stack;

public class Jump {

    public static void main(String[] args){
        int[] arr = {0,3,1,1,4};
        System.out.println(canJump(arr));
    }


    public static boolean canJump(int[] arr) {

        int farthest = 0;

        for (int i = 0; i < arr.length; i++) {

            // We cannot reach this index
            if (i > farthest) {
                return false;
            }

            // Update the farthest position we can reach
            farthest = Math.max(farthest, i + arr[i]);

            // Already reached the last index
            if (farthest >= arr.length - 1) {
                return true;
            }
        }

        return true;
    }




}



