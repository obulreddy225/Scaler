package com.jmp.dsa.slidingwindow;

public class MaxVowels {
    public static int maxVowels(String s, int k) {
        int count = 0;
        // First window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        int maxVowels = count;
        // Remaining windows
        int si = 1;
        int ei = k;
        while (ei < s.length()) {
            // Remove character leaving the window
            if (isVowel(s.charAt(si - 1))) {
                count--;
            }
            // Add character entering the window
            if (isVowel(s.charAt(ei))) {
                count++;
            }
            maxVowels = Math.max(maxVowels, count);
            si++;
            ei++;
        }
        return maxVowels;
    }
    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u';
    }
}
