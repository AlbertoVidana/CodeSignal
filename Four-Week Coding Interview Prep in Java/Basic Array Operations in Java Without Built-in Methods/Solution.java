/**
 * You are given an array of integers. Your task is to 
 * write a function findMinElement, that returns 
 * the minimum number from the array without using 
 * Java's built-in methods such as Arrays.stream().min().
 * If the array is empty, your function should return null.
 */

public class Solution {
    public Integer findMinElement(int[] array) {
        // TODO: implement the function to find the minimum number from an array
        if (array == null) return null;
        if (array.length == 0) return null;
        int min = array[0];
        for (int i : array) {
            if (i < min) min = i;
        }
        return min;
    }
}