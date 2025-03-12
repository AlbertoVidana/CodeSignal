package src.acip.hashmap.unit3;

/**
 * Finding Minimum Quantity in Fruit Inventory
 * 
 * In your grocery store inventory system, you have code that currently 
 * calculates the maximum quantity of items. Now, you need to modify 
 * the code to calculate the average quantity of items in the inventory. 
 * To achieve this, use Java's iterative methods to sum the quantities 
 * and then divide by the number of items. Ready for the challenge?
 */

import java.util.HashMap;
import java.util.Collections;

class Practice1 {
    public static void main(String[] args) {
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("potatoes", 30);
        inventory.put("carrots", 25);
        inventory.put("onions", 15);

        // Finding the maximum quantity among the inventory
        // int maxQuantity = Collections.max(inventory.values());
        // System.out.println("The maximum quantity of any item in the shop is: " + maxQuantity);
        
        int totalItems = 0;
        for (int value : inventory.values()) {
            totalItems += value;
        }
        
        // Calculate the average quantity
        double averageItems = (double) totalItems / inventory.size();
        System.out.println("Average number of items: " + averageItems);
    }