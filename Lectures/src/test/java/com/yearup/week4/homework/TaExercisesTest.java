package com.yearup.week4.homework;

import com.yearup.week4.code.arrays.TaExercises;
import com.yearup.week4.code.linkedlist.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TaExercisesTest {

    @Test
    public void testtargetTwoNumberSumOn2(){
        //#1 Given an array of integers, return two numbers such that sum is equal to a given target.
        int arr[] = {3, 5, -4, 8, 11, 1, -1, 6};
        int target = 15;
        int expArr[] = {5, 8};
        int actArr[] = TaExercises.targetTwoNumberSumOn2(arr, 13);
        boolean out = Arrays.equals(expArr, actArr);
        System.out.println("TwoNumberSum found " + out + " " + Arrays.toString(actArr));
        assertEquals(out, true);
    }
}
