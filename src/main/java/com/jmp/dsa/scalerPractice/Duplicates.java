package com.jmp.dsa.scalerPractice;

import java.util.HashSet;
import java.util.Set;

public class Duplicates {
    public static boolean haveDuplicates(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
