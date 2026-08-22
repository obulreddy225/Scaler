package com.jmp.dsa.slidingwindow;

public class LongestUniformSubString {


    //Longest uniform subsequence - Find start index and length of longest repeating substring
    //    Input : "aabbbcca"
    //    Output: index = 2 and length = 3 ("bbb")
    //    Input : "aaabbhhhhhbcca"
    //    Output: index = 5 and length = 5 ("hhhhh")
    public static void longestUniformSubstring(String str) {

        int start = 0;
        int maxStart = 0;
        int maxLength = 1;

        for (int i = 1; i < str.length(); i++) {

            // Character changed → start a new group
            if (str.charAt(i) != str.charAt(i - 1)) {
                start = i;
            }

            // Current group's length
            int currentLength = i - start + 1;

            // Update maximum
            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxStart = start;
            }
        }

        System.out.println("index = " + maxStart);
        System.out.println("length = " + maxLength);
    }
}
