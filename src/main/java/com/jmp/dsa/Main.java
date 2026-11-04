package com.jmp.dsa;

public class Main {
    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "pqrs";
        System.out.println(combinedString(str1,str2));



    }

//    str1=abc
//            str2=pqrs
//    o/p=apbqcrs

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
