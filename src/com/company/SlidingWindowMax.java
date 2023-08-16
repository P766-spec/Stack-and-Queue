package com.company;
//  https://leetcode.com/problems/sliding-window-maximum/

import java.util.*;
public class SlidingWindowMax {
    public static void main(String[] args) {
           int[] a = {1,3,-1,-3,5,3,6,7};
           int k = 3;
           int[] ans = maxSlidingWindow(a, k);
           for(int num :  ans) {
               System.out.println(num  +" ");
           }
    }
     static int[] maxSlidingWindow(int[ ] a , int k){
        int n = a.length;
        int[] r = new int[ n - k + 1];
        int ri  = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
         for (int i = 0; i < a.length; i++) {
             // remove  numbers out of range k
             if(!q.isEmpty() && q.peek() == i - k) {
                 q.poll();
             }
             // remove smaller numbers in k range as they are useless
             while(!q.isEmpty() && a[q.peekLast()] < a[i]) {
                 q.pollLast();
             }
             q.offer(i);
             if( i >= k - 1) {
                 r[ri++] = a[q.peek()];
             }
         }
         return r;
     }
}
