package com.jmp.dsa.scaler.scaler0;

//Write a function that takes an integer and returns the number of 1 bits present in
// its binary representation.
public class NumSetBits {
    public int numSetBits(int A) {
        int count = 0;

        while (A > 0) {
            // Check whether A is odd or even.
            // If A is odd, the rightmost bit is 1, so increment count.
            if ((A & 1) == 1) {
                count++;
            }

            // Right shift by 1
            A = A >> 1;
        }

        return count;
    }
}



