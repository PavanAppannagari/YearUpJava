package com.yearup.week4.code.complexity;

/*Given an array of integers, return two numbers such that sum
is equal to a given target.*/

import java.io.*;
import java.util.*;

public class TwoNumberSum {
    //Time complexity: O(n^2)
    public static int[] targetTwoNumberSumOn2(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[] { arr[i], arr[j] };
                }
            }
        }
        return new int[] {};
    }
    //Time complexity: O(n)
    public static int[] targetTwoNumberSumOn(int[] arr, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (numMap.containsKey(complement)) {
                return new int[] { arr[numMap.get(complement)], arr[i]};
            } else {
                numMap.put(arr[i], i);
            }
        }
        return new int[] {};
    }
    // Time complexity: O(n*logn)
    public static int[] targetTwoNumberSumnlogn(int[] arr, int target){
        String str="";
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while(left < right){
            if(arr[left] + arr[right] < target){
                left++;
            }else if(arr[left] + arr[right] == target){
                int retArr[] = {arr[left], arr[right]};
                left++;
                right--;
                return retArr;
            }else{
                right--;
            }
        }
        return new int[] {};
    }
    public static void main(String[] args) throws Exception {
        int arr[] = {3,5,-4,8,11,1,-1,6};
        int target=13;
        int op1[]=targetTwoNumberSumOn2(arr,target);
        System.out.println(Arrays.toString(op1));
        int op2[]=targetTwoNumberSumOn(arr,target);
        System.out.println(Arrays.toString(op2));
        int op3[]=targetTwoNumberSumnlogn(arr,target);
        System.out.println(Arrays.toString(op3));
    }

}
