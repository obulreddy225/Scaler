package com.jmp.dsa.slidingwindow;

public class minimumNumberOfSwaps {
//   Count 1s
//   ↓
//    k = number of 1s
//   ↓
//    First window → count zeros
//   ↓
//    Slide window
//   ↓
//    Remove left element
//    Add right element
//   ↓
//    Keep minimum zeros

    //0,1,0,1,0,1

    //1

    public static int minMoves(int[] arr) {

        int n = arr.length;

        // Step 1: Count total number of 1s
        int ones = 0;

        for (int num : arr) {
            if (num == 1) {
                ones++;
            }
        }

        // If 0 or 1 one, no moves required
        if (ones <= 1) {
            return 0;
        }

        // Step 2: First window of size 'ones'
        int windowZeros = 0;


        for (int i = 0; i < ones; i++) {
            if (arr[i] == 0) {
                windowZeros++;
            }
        }

        // Step 3: Minimum zeros found so far
        int minMoves = windowZeros;

        // Step 4: Sliding window
        int si = 1;
        int ei = ones;

        while (ei < n) {

            // Remove the outgoing element
            if (arr[si - 1] == 0) {
                windowZeros--;
            }

            // Add the incoming element
            if (arr[ei] == 0) {
                windowZeros++;
            }

            // Minimum zeros = minimum moves
            minMoves = Math.min(minMoves, windowZeros);

            si++;
            ei++;
        }

        return minMoves;
    }

    //Traverse from left to right
    //
    //If current character == previous character:
    //        currentLength++
    //
    //Else:
    //        start a new sequence
    //        currentStart = current index
    //        currentLength = 1
    //
    //If currentLength > maxLength:
    //        update maxStart
    //        update maxLength
    public static void longestUniformSubstring(String str) {

        int currentStart = 0;
        int currentLength = 1;

        int maxStart = 0;
        int maxLength = 1;

        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) == str.charAt(i - 1)) {
                currentLength++;
            } else {
                currentStart = i;
                currentLength = 1;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxStart = currentStart;
            }
        }

        System.out.println("index = " + maxStart);
        System.out.println("length = " + maxLength);
        System.out.println("substring = " + str.substring(maxStart, maxStart + maxLength));
    }

}
