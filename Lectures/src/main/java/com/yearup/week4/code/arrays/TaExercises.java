package com.yearup.week4.code.arrays;

import com.yearup.week4.code.complexity.TwoNumberSum;

import java.util.Arrays;

public class TaExercises {
        //#1 Given an array of integers, return two numbers such that sum is equal to a given target.
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

        //
    //#2 Given a number n and a digit d, calculate the frequency of digit d in number n.

    public static int getDigitFrequency(int num, int dig) {
        int freq = 0;
        while (num > 0) {
            int rem = num % 10;
            num = num / 10;

            if (rem == dig) {
                freq++;
            }
        }
        return freq;
    }

    //#3 Given an Array of numbers find the span of the Array
    public static int spanOfArray(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int span = max - min;
        return span;
        }

    //#4 mirror-inverse
    static boolean isMirrorInverse(int arr[])
    {
        for (int i = 0; i < arr.length; i++) {

            // If condition fails for any element
            if (arr[arr[i]] != i)
                return false;
        }

        // Given array is mirror-inverse
        return true;
    }

    //#5 Palindrome
    public static boolean isPalindrome(String str)
    {
        // Initializing an empty string to store the reverse
        // of the original str
        String rev = "";

        // Initializing a new boolean variable for the
        // answer
        boolean ans = false;

        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }

        // Checking if both the strings are equal
        if (str.equals(rev)) {
            ans = true;
        }
        return ans;
    }

    //#6 Convert decimal to base
    public static int convertDecValuetoBase(int n, int b){
        int rv = 0;
        int p = 1;
        while(n > 0){
            int d = n % b;
            n = n / b;
            rv += p * d;
            p = p * 10;
        }
        return rv;
    }

   // #7 Binary Search
   public static int binarySearch(int arr[], int num)
    {
        //Arrays.sort(arr); //Just in case if Array is not sorted
        int l = 0;
        int h = arr.length - 1;

        while (l <= h) {
            int idx = (l + h) / 2;
            if (num > arr[idx]) {
                l = idx + 1;
            } else if (num < arr[idx]) {
                h = idx - 1;
            } else {
                System.out.println(idx);
                return idx;
            }
        }
        return -1;
    }

    //#8 Saddle Point
    static boolean findSaddlePoint(int mat[][], int n)
    {// Process all rows one by one
        for (int i = 0; i < n; i++)
        {   // Find the minimum element of row i.
            // Also find column index of the minimum element
            int min_row = mat[i][0], col_ind = 0;
            for (int j = 1; j < n; j++)
            {
                if (min_row > mat[i][j])
                {
                    min_row = mat[i][j];
                    col_ind = j;
                }
            }
            // Check if the minimum element of row is also
            // the maximum element of column or not
            int k;
            for (k = 0; k < n; k++)
                // Note that col_ind is fixed
                if (min_row < mat[k][col_ind])
                    break;

            // If saddle point is present in this row then
            // print it
            if (k == n)
            {
                System.out.println("Value of Saddle Point " + min_row);
                return true;
            }
        }

        // If Saddle Point not found
        return false;
    }



    public static void main(String[] args) {
        //#1 Given an array of integers, return two numbers such that sum is equal to a given target.
        int arr[] = {3, 5, -4, 8, 11, 1, -1, 6};
        int target = 15;
        int expArr[] = {5, 8};
        int actArr[] = TaExercises.targetTwoNumberSumOn2(arr, 13);
        boolean out = Arrays.equals(expArr, actArr);
        System.out.println("TwoNumberSum found " + out + " " + Arrays.toString(actArr));

        //#2 Given a number n and a digit d, calculate the frequency of digit d in number n.
        int dfreq = TaExercises.getDigitFrequency(886563264, 6);
        System.out.println("Digit Frequency is: " + dfreq);

        //#3 Given an Array of numbers find the span of the Array
        int arr2[] = {3,5,4,8,11,1,12,1,6};
        int span = TaExercises.spanOfArray(arr2);
        System.out.println("Span of the Array is: " + span);

        //#4 mirror-inverse
        int arr3[] = {3, 4, 2, 0, 1};
        System.out.println("Array is its own mirror inverse: " + TaExercises.isMirrorInverse(arr3));
        int arr4[] = {1, 2, 3, 0};
        System.out.println("Array is its own mirror inverse: " + TaExercises.isMirrorInverse(arr4));

        //#5 Palindrome
        // Input string
        //String str = "ateststring";
        String str = "reviver";
        // Convert the string to lowercase
        str = str.toLowerCase();
        boolean test = isPalindrome(str);
        System.out.println("Is input string a Palindrome? "+test);

        //#6 Convert decimal to base
        int base = convertDecValuetoBase(634,8);
        System.out.println("converted value of decimal to base "+base);

        // #7 Binary Search
        int arr5[] = {10, 20, 30, 50, 60, 80, 110, 130, 140, 170};
        int index=binarySearch(arr5,110);
        if(index==-1)
            System.out.println("element not found in array");
        else
            System.out.println("element found at index in array at: "+index);

        // #8 saddle point of the matrix
        int mat[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int n = 3;
        if (findSaddlePoint(mat, n) == false){
            System.out.println("No Saddle Point ");
    }



    }
}
