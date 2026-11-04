
package com.jmp.dsa.twoPointer;

import javax.security.auth.callback.CallbackHandler;
import java.lang.management.ManagementFactory;
import java.util.*;

public class Main {
    //10. Merge Two Sorted Arrays (With Extra Space)
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        int[] result = new int[m+n];
        int i =0;
        int j =0;
        int k =0;

        while (i<m &&j<n){
            if(arr1[i]<arr2[j]){
                result[k++]=arr1[i++];
            }else {
                result[k++]=arr2[j++];
            }
        }

        while (i<m){
            result[k++]=arr1[i++];
        }
        while (j<n){
            result[k++]=arr2[j++];
        }
        return result;
    }

    public static int uniqueSubString(String str){
        Set<Character> set = new HashSet<>();
        int left =0;
        int maxLength =0;
        for(int right =0;right<str.length();right++){
            char ch = str.charAt(right);
            while (set.contains(ch)){
                 set.remove(str.charAt(left));
                 left++;
            }
            set.add(ch);
            if(right-left+1>maxLength){
                maxLength =right-left+1;
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {

    }
}
