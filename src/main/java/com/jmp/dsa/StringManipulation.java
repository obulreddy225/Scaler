package com.jmp.dsa;

public class StringManipulation {

    public static String compressString(String str) {

        StringBuilder builder = new StringBuilder();

        int i = 0;

        while (i < str.length()) {

            char ch = str.charAt(i);
            int count = 0;

            while (i < str.length() && str.charAt(i) == ch) {
                count++;
                i++;
            }

            builder.append(ch).append(count);
        }

        return builder.toString();
    }

    public static String expandString(String str) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < str.length(); i += 2) {

            char ch = str.charAt(i);
            int count = Character.getNumericValue(str.charAt(i + 1));

            while (count > 0) {
                builder.append(ch);
                count--;
            }
        }

        return builder.toString();
    }

    public static String combinedString (String str1, String str2){
        int i=0;
        int j=0;
        StringBuilder result = new StringBuilder();

        while (i<str1.length() || j<str2.length()){
            if(i< str1.length()){
                result.append(str1.charAt(i++));
            }
            if(j<str2.length()){
                result.append(str2.charAt(j++));
            }
        }
        return result.toString();
    }



    public static void longestUniformSubstring(String str) {

        int startIndex = 0;
        int currentLength = 1;
        int maxStart = 0;
        int maxLength = 1;

        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) == str.charAt(i - 1)) {
                currentLength++;
            } else {
                startIndex = i;
                currentLength = 1;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxStart = startIndex;
            }
        }

        System.out.println("index = " + maxStart);
        System.out.println("length = " + maxLength);
    }

    public static String sortVowels(String s) {


        int[] count = new int[128];

        // Count vowels
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isVowel(ch)) {
                count[ch]++;
            }
        }

        StringBuilder result = new StringBuilder(s);

        int vowel = 0;

        // Put vowels back in sorted ASCII order
        for (int i = 0; i < s.length(); i++) {

            if (isVowel(s.charAt(i))) {

                while (count[vowel] == 0) {
                    vowel++;
                }

                result.setCharAt(i, (char) vowel);
                count[vowel]--;
            }
        }

        return result.toString();
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' ||
                ch == 'O' || ch == 'U';
    }


    //books Exchange
    public static int bookExchange(int m, int c, int x){
        int readBooks = m/c;
        int usedBooks = readBooks;

        while (usedBooks>=x){
            int newBooks = usedBooks/x;
            usedBooks = (usedBooks%x)+newBooks;
            readBooks+=newBooks;
        }
        return readBooks;
    }

    public static String sortVowel(String str){
        int[] count = new int[128];

        for (int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(isVowel(ch)){
                count[ch]++;
            }
        }
        StringBuilder result = new StringBuilder(str);
        int vowel =0;
        for (int i=0;i<str.length();i++){
            if (isVowel(str.charAt(i))){
                while (count[vowel]==0){
                    vowel++;
                }
                result.setCharAt(i,(char)vowel);
                count[vowel]--;
            }
        }
        return result.toString();
    }
}
