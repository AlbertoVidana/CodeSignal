package src.acip.hashmap.unit3;

/**
 * Finding Minimum Quantity in Fruit Inventory
 * 
 * In this exercise, you have a small program intended to calculate and 
 * display the minimum quantity of a single type of fruit in a grocery shop's inventory. 
 * However, there's a bug preventing it from working correctly. Your task is to find 
 * and fix the bug without adding or removing any lines of code.
 */

import java.util.HashMap;
import java.util.Collections;

class Practice2 {
    public static void main(String[] args) {
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("apples", 30);
        inventory.put("bananas", 45);
        inventory.put("cherries", 25);

        // Calculate the minimum quantity of a single fruit type in the inventory
        int minQuantity = Collections.min(inventory.keySet());

        System.out.println("The minimum quantity of a single type of fruit in the inventory is: " + minQuantity);
    }
}