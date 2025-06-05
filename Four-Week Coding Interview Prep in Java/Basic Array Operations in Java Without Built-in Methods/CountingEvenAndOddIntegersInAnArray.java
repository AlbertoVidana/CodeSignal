/**
 * You are given an array of integers. Your job is to return 
 * the count of even and odd integers in the given array 
 * without using any built-in Java methods.
 * Your function should return an array in 
 * the format {even_count, odd_count}, where even_count 
 * represents the number of even integers and odd_count 
 * represents the number of odd integers in the provided array.
 */

public class CountingEvenAndOddIntegersInAnArray {
    public int[] solution(int[] nums) {
        // TODO: implement the function to return an array {even_count, odd_count}
        int[] solution = new int[2];
        int even = 0, odd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) even++;
            else odd++;
        }
        solution[0] = even;
        solution[1] = odd;
        return solution;
    }
}
