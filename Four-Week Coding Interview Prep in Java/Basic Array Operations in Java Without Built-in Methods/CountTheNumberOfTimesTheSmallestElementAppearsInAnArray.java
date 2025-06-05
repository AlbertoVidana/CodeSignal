/**
 * ou are given an array of integers. Your task is to 
 * write a function in Java that returns the number of 
 * times the smallest element appears in the array.
 * Please note that built-in methods such 
 * as Collections.min() or Collections.frequency() 
 * should not be used in this task. 
 * Your goal is to accomplish this task by iterating 
 * over the array elements manually. Try to solve the 
 * task by doing just a single array traversal.
 */
public class CountTheNumberOfTimesTheSmallestElementAppearsInAnArray {
    public int countMin(int[] numbers) {
        // TODO: Implement this function to count the smallest integer in the array.
        if (numbers.length < 1) return 0;
        int min = Integer.MAX_VALUE;
        int counMin = 0;
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
            if (numbers[i] < min) {
                min = numbers[i];
                counMin = 1;
            } else if (numbers[i] == min) {
                counMin++;
            }
        }
        return counMin;
    }
}
