package com.company;
//  https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.*;
public class MaxAreaHistogram {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3));
        int maxArea = largestRectangle(arr);
        System.out.println("Largest Rectangle Area: "  +maxArea);


    }
    static int largestRectangle(ArrayList<Integer> arr){
        int n = arr.size();
        Stack<Integer> s = new Stack<>();
        int[] nsl = new int[n];
        int[] nsr = new int [n];

        // Nearest Smallest ot right
        for(int i = n -1; i>=0 ; i--){
            while(!s.isEmpty() && arr.get(s.peek()) >= arr.get(i)) {
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = n;
            } else {
                nsr[i]  = s.peek();
            }
            s.push(i);
        }

        // Nearest Smallest to Left
        s = new Stack<>();
        for(int i = 0; i<n; i++){
            while(!s.isEmpty() && arr.get(s.peek()) >= arr.get(i)) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // Maximum Area

        int maxA = Integer.MIN_VALUE;
        for(int i =0; i<n; i++){
            int height = arr.get(i);
            int width = nsr[i] - nsl[i] - 1;
            int area = height * width;
            maxA = Math.max(area, maxA);
        }
        return maxA;

    }
}
