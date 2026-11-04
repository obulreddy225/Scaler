package com.jmp.dsa.twoPointer;

public class StringProblem {
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
}
