package src.acip.hashmap.unit3;

/**
 * Determine the Maximum Count of Any Fruit in Inventory
 * 
 * Determine the maximum count of any one type of fruit in a fruit stand's inventory using Java. 
 * Utilize your knowledge on data aggregation with HashMap to accomplish this task.
 */
import java.util.HashMap;
import java.util.Collections;

class Solution {
    public static void main(String[] args) {
        // TODO: Create a HashMap representing the inventory with fruits as keys and their quantities as values
        HashMap<String, Integer> fruitInventory = new HashMap<>();
        fruitInventory.put("apples", 30);
        fruitInventory.put("bananas", 15);
        fruitInventory.put("cherries", 45);

        // TODO: Use the Collections.max method to find the max count of a single type of fruit
        int maxNoItems = Collections.max(fruitInventory.values());

        // TODO: Print out the maximum count of any fruit in the inventory
        System.out.print("The maximum count is " + maxNoItems);
    }
}