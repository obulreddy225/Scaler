
package com.jmp.dsa.misc;

import java.util.Enumeration;

public class Main {

    // 1,2,3,4,5,6,7,8,9      6
    public static int smallestDivisor(int[] arr, int threshold) {
        int left = 1;
        int right = 0;

        for (int num : arr) {
            right = Math.max(right, num);
        }

        while (left<=right){
            int divisor = left + (right-left)/2;
            int sum= 0;
            for(int num:arr){
                sum+=(num+divisor-1)/divisor;
            }
            if(sum<=threshold){
                right =divisor-1;
            } else  {
                left =divisor +1;
            }
        }
        return left;
    }
}
