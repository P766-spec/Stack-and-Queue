package com.company;
// https://leetcode.com/problems/next-greater-element-i/
import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {7, 12, 1, 20};
        int n = arr.length;
        int[] result = nextGreaterElement(arr, n);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    static int[] nextGreaterElement(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }
            ans[i] = s.isEmpty() ? -1 : s.peek();
            s.push(arr[i]);
        }
        return ans;
    }
}
