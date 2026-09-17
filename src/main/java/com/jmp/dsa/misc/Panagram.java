package com.jmp.dsa.misc;

public class Panagram {
    public static String missingAlphabets(String str) {

        boolean[] present = new boolean[26];

        for (char ch : str.toCharArray()) {

            if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);

                if (ch >= 'a' && ch <= 'z') {
                    present[ch - 'a'] = true;
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 26; i++) {

            if (!present[i]) {
                result.append((char) ('a' + i));
            }
        }

        return result.toString();
    }
}
