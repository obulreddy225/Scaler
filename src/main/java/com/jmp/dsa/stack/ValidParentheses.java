    package com.jmp.dsa.stack;

    import java.util.Stack;

    public class ValidParentheses {

        public static boolean isValid(String str) {
           Stack<Character> stack = new Stack<>();
           for(char ch:str.toCharArray()){
               if(ch=='(' || ch =='[' || ch == '{'){
                   stack.push(ch);
               }else {
                   if(stack.isEmpty()){
                       return false;
                   }
                   char top = stack.pop();
                        if((ch == ')' && top!='(' ||
                           (ch ==']' && top!='[') ||
                           (ch == '}' && top!='{'))){
                       return false;

                   }

               }

           }
            return stack.isEmpty();
        }
    }