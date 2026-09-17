package com.jmp.dsa;

public class StringManipulation {



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
