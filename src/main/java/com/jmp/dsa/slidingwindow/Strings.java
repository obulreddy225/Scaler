package com.jmp.dsa.slidingwindow;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public record Strings() {

    public static int longestSubString(String str) {
        int left = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        for (int right = 0; right < str.length(); right++) {

            while (set.contains(str.charAt(right))) {
                set.remove(str.charAt(left));
                left++;
            }
            set.add(str.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static String compression(String str) {
        StringBuilder result = new StringBuilder();
        int n = str.length();
        int i = 0;
        while (i < n) {
            char ch = str.charAt(i);
            int count = 0;
            while (i < n && str.charAt(i) == ch) {
                count++;
                i++;
            }
            result.append(ch).append(count);

        }
        return result.toString();
    }

    public static String expansion(String str){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<str.length();i+=2){
            char ch = str.charAt(i);
            int count = str.charAt(i+1)-'0';

            while (count>0){
                result.append(ch);
                count--;
            }
        }
        return result.toString();
    }


    public static void main(String str) {

    }
}
