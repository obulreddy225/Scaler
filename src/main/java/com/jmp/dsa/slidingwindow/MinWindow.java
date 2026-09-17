package com.jmp.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    // Input: s = "OUZODYXAZV", t = "XYZ"
    public static String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();

        // Frequency of characters required from t
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;

        int required = t.length();
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        while (right < s.length()) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    required--;
                }

                map.put(ch, map.get(ch) - 1);
            }

            right++;

            // Window contains all characters of t
            while (required == 0) {

                if (right - left < minLength) {
                    minLength = right - left;
                    minStart = left;
                }

                char leftChar = s.charAt(left);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);

                    if (map.get(leftChar) > 0) {
                        required++;
                    }
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(minStart, minStart + minLength);
    }
}
