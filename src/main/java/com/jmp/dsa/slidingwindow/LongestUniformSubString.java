package com.jmp.dsa.slidingwindow;

public class LongestUniformSubString {


    //Longest uniform subsequence - Find start index and length of longest repeating substring
    //    Input : "aabbbcca"
    //    Output: index = 2 and length = 3 ("bbb")
    //    Input : "aaabbhhhhhbcca"
    //    Output: index = 5 and length = 5 ("hhhhh")
    public static void longestUniformSubstring(String str) {

        if (str == null || str.isEmpty()) {
            return;
        }

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
        System.out.println("substring = " +
                str.substring(maxStart, maxStart + maxLength));
    }
}
