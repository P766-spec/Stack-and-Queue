package com.company;
// https://leetcode.com/problems/valid-parentheses/

import java.util.*;
public class ValidParentheses {
    public static void main(String[] args) {
           String exp = "{()}[]";
           if(isValid(exp))
               System.out.println("Valid");
           else
               System.out.println("Not Valid");
    }

    // brute force
//    static boolean isValid(String s){
//        int i =-1;
//        char[]  valid = new char[s.length()];
//        for(char ch : s.toCharArray()) {
//            if(ch == '(' || ch == '{' || ch =='[')
//                valid[++i] = ch;
//            else {
//                if( i >= 0 && ((valid[i] == '(' && ch == ')')
//                || (valid[i] == '{'  && ch == '}')
//                || (valid[i] == '[' && ch == ']')))
//                    i--;
//                else
//                    return false;
//            }
//        }
//        return i == -1;
//    }

   // Using Stack
    static  boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c =='{' || c == '[') {
                st.push(c);
            }
            else if (st.isEmpty()) return false;
              else if (st.peek() == '(' && c == ')' && !st.isEmpty()) {
                  st.pop();
            }
              else if (st.peek() == '[' && c== ']' && !st.isEmpty()) {
                st.pop();
            }
              else if (st.peek() == '{' && c == '}' && !st.isEmpty()) {
                  st.pop();
            }
              else {
                  return false;
            }
        }
        return st.isEmpty();
    }
}
