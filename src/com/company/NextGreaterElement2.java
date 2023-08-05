package com.company;
//  https://leetcode.com/problems/next-greater-element-ii/

import java.util.*;
public class NextGreaterElement2 {
    public static void main(String[] args) {
                 int[] nums = {1, 2, 1};
                 int[] ans = nextGreaterElement(nums);
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
    static int[] nextGreaterElement(int[] nums){
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length - 1; i>=0; i--){
            stack.push(nums[i]);
        }
        int[] greater = new int[nums.length];
        for(int i =nums.length - 1; i>= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            greater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return greater;
    }
}
