package com.company;
//  https://www.codingninjas.com/studio/problems/next-smaller-element_1112581?leftPanelTab=0

import java.util.*;
public class NextSmallerElement {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 3,1));
        int n = arr.size();
        ArrayList<Integer> result = nextSmallerElement(arr,n);

        System.out.println("Next Smaller ELements: ");
        for(int val : result){
            System.out.println(val + " ");
        }
    }

    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        Stack<Integer> st = new Stack<>();

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = arr.size() - 1; i>=0; i--){
            while(!st.isEmpty() && st.peek( )>= arr.get(i)){
                st.pop();
            }
            if(st.isEmpty()){
                ans.add(-1);
            } else {
                ans.add(st.peek());
            }
            st.push(arr.get(i));
        }
        Collections.reverse(ans);
        return ans;
    }
}
