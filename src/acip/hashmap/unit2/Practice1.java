package acip.hashmap.unit2;

/**
 * You've been working with Java HashMap to count occurrences of each color in a list. 
 * Now, we'll focus on refining your skills to count elements in a list more efficiently. 
 * Your task is to optimize the existing Java code that counts how many times each color 
 * appears by using the HashMap features effectively!
 */

import java.util.HashMap;
import java.util.ArrayList;

// Java program to count occurrences of colors in a list
class Practice1 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        colors.add("blue");

        HashMap<String, Integer> colorMap = new HashMap<>();

        for (String color : colors) {
            // Check if the color is already in the map
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
        }
        
        for (String key : colorMap.keySet()) {
            System.out.println(key + ": " + colorMap.get(key));
        }
    }
}