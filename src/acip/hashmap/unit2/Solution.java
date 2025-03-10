package acip.hashmap.unit2;
/**
 * Introduction to HashMaps in Java for Counting Occurrences
 * 
 * Time Complexity Analysis
 * The time complexity of our approach is O(n), where n is the number of elements in our list. 
 * This is because we iterate over our list exactly once, performing constant-time operations for each element. 
 * Here is why: Accesses to the HashMap (both setting a value and getting a value) 
 * in Java are typically O(1), constant-time operations.
 * The for loop iterates over each element in the list exactly once, so it is an O(n) operation. 
 * The total time complexity, therefore, remains O(n) because the time taken is directly 
 * proportional to the number of items in the list. As the size of the list increases, the time taken 
 * scales linearly, making this approach efficient for larger collections.
 * It is also worth noting that the space complexity of this approach is O(k), where k is the number 
 * of unique elements in the list. In the worst-case scenario, where all elements are unique, 
 * the space complexity would be O(n).
 * In conclusion, using HashMaps for counting is a time-efficient approach, especially when working with large datasets.
 */
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        colors.add("blue");

        HashMap<String, Integer> colorMap = new HashMap<>();
        // Start the loop to iterate over each color
        for (String color : colors) {
            // If the color is present in our HashMap, increment its value by 1
        	// TODO: Implement the optimized solution leverages the getOrDefault method:
            if (colorMap.containsKey(color)) {
                colorMap.put(color, colorMap.get(color) + 1);
            } else {
                // If the color isn't present, it means we're encountering this color in our list for the first time.
                // In this case, we add it to our HashMap and set its value to 1
                colorMap.put(color, 1);
            }
            
        }

        // Print our HashMap with counts
        for (String key : colorMap.keySet()) {
            System.out.println(key + ": " + colorMap.get(key));
        }
    }
}

//TODO: Here is the optimized solution getOrDefault method >_<
//Iterate over each color and increase its count
//for (String color : colors) {
//    colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
//}