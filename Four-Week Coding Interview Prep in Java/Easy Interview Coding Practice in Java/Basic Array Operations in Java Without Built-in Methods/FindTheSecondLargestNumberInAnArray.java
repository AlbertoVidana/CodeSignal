/**
 * You are given an array of integers. Your task is to 
 * write a Java function to find the second-largest 
 * number among these integers. If the array has 
 * fewer than two unique numbers, return null.
 * You are not allowed to use any built-in Java 
 * methods for sorting or finding maximums (e.g., Arrays.sort, Collections.max). 
 * Instead, you should implement the task using basic array operations.
 */
public class FindTheSecondLargestNumberInAnArray {
    public Integer secondMax(int[] nums) {
        // TODO: Find the second largest number in nums
        boolean noSecond = true;
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        if (nums.length < 2) return null;
        for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            if (nums[i] > first) {
                if (first > second) {
                    second = first;
                    noSecond = false;
                }
                first = nums[i];
            }
            if (nums[i] >= second && nums[i] < first) {
                second = nums[i];
                noSecond = false;
            }
        }
        System.out.println("Second?: " + noSecond + " second: " + second);
        if (noSecond) return null;
        if (first == second) return null;
        return second;
    }
}
