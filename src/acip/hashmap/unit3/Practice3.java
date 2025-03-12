package src.acip.hashmap.unit3;

/**
 * Data Aggregation in a Grocery Inventory Using HashMap
 * 
 * Now that you've familiarized yourself with data aggregation using 
 * HashMaps, it's time to put your skills to practical use! You are given 
 * a HashMap representing the inventory of a grocery shop, with fruit names 
 * as keys and their quantities as values. Your task is to write Java code 
 * that calculates the total number of items in the inventory and 
 * determines the maximum quantity of a single fruit type.
 */
import java.util.HashMap;
import java.util.Collections;

import java.util.HashMap;
import java.util.Collections;

class Practice3 {
    public static void main(String[] args) {
        // Inventory HashMap for a grocery shop
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("apples", 30);
        inventory.put("bananas", 45);
        inventory.put("oranges", 25);
        inventory.put("pears", 10);

        // TODO: Calculate the total items in the inventory and print it
        int totalItems = 0;
        for (int item : inventory.values()) {
            totalItems += item;
        }
        System.out.println("The total number of items is: " + totalItems);

        // TODO: Find the maximum quantity of a single fruit type in the inventory and print it
        int maxQuantity = Collections.max(inventory.values());
        System.out.println("The maximum quantity fo a single fruit is: " + maxQuantity);
    }
}