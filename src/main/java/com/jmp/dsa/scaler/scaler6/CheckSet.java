package com.jmp.dsa.scaler.scaler6;

public class CheckSet {
    public static boolean checkBit(int num, int i) {
        return ((num >> i) & 1) == 1;
    }

//                00110010   ← 50
//              & 00000010   ← 1 << 1
//              -----------
//                00000010
//
//    We got a non-zero value → position 1 contains 1.
    public static boolean leftShift(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    public static int duplicate(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }
        return result;
    }

}
