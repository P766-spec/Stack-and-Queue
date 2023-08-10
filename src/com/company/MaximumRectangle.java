package com.company;
// https://leetcode.com/problems/maximal-rectangle/

import java.util.*;
public class MaximumRectangle {
    public static void main(String[] args) {
        char[][] matrix= {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));

    }
    static int maximalRectangle(char[][] matrix){
        int m = matrix.length;
        int n= matrix[0].length;
        int[] height = new int[n];

        int result =Integer.MIN_VALUE;

        for(int i = 0; i<m; i++){
            for(int j =0 ; j<n; j++){
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
            }

            result = Math.max(result, MAH(height, n));
        }
        return result;
    }
    private static int MAH(int[] height, int n){
        int maxArea = Integer.MIN_VALUE;
        List<Integer> nsl = NSL(height, n);
        List<Integer> nsr = NSR(height, n);
        int[] width = new int[n];

        for(int i =0; i<n; i++)
            width[i] = nsr.get(i) - nsl.get(i) - 1;

            for(int i =0; i<n; i++) {
                int area = height[i] * width[i];
                maxArea = Math.max(maxArea, area);
            }
            return maxArea;
    }
    private static List<Integer> NSL(int[] height, int n){
        List<Integer> nsl = new ArrayList<>();
        Stack<int[]> stk = new Stack<>();

        for(int i =0; i<n; i++){
            int curr = height[i];
            while(!stk.isEmpty() && stk.peek()[0] >= curr){
                stk.pop();
            }
            if(stk.isEmpty()) nsl.add(-1);
            else nsl.add(stk.peek()[1]);
            stk.add(new int[] {curr, i});
        }
        return nsl;
    }

    private static List<Integer> NSR(int[] height, int n){
        List<Integer> nsr = new ArrayList<>();
        Stack<int[]> stk = new Stack<>();

        for(int i = n - 1; i>=0; i-- ){
            int curr = height[i];
            while(!stk.isEmpty() && stk.peek()[0] >= curr){
                stk.pop();
            }
            if(stk.isEmpty()) nsr.add(n);
            else nsr.add(stk.peek()[1]);
            stk.add(new int[] {curr, i});
        }
        Collections.reverse(nsr);
        return nsr;
    }
}
