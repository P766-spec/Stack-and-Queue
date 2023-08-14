package com.company;
//  https://leetcode.com/problems/min-stack/

import java.util.*;
public class MinStack {

        public static void main(String[] args) {
            MinStack minStack = new MinStack();

            minStack.push(3);
            minStack.push(5);
            minStack.push(2);
            minStack.push(7);

            System.out.println("Top element: " + minStack.top()); // Output: 7
            System.out.println("Minimum element: " + minStack.getMin()); // Output: 2

            minStack.pop();
            System.out.println("Top element after pop: " + minStack.top()); // Output: 2
            System.out.println("Minimum element after pop: " + minStack.getMin()); // Output: 2
        }



    Stack <Long> st = new Stack<>();
    Long minEle;

    public MinStack() {
        minEle = Long.MAX_VALUE;
    }

    public void push(int val){
        Long value = Long.valueOf(val);
        if(st.isEmpty()) {
            minEle = value;
            st.push(value);
        }
        else {
            if(value < minEle){
                st.push( 2 * value - minEle );
                minEle = value;
            }
            else {
                st.push(value);
            }
        }
    }
    public void pop() {
        if(st.isEmpty()){
            return;
        }

        Long value = st.pop();
        if(value < minEle){
            minEle = 2 * minEle - value;   // for going again to previous element.
        }
    }

    public int top() {
        Long value = st.peek();
        if(value < minEle){
            return minEle.intValue();
        }
        return value.intValue();
    }

    public int getMin() {
        return minEle.intValue();
    }
}
