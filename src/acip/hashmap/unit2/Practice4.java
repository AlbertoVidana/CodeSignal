package acip.hashmap.unit2;

/**
 * 
 * 
 * In this task, you will be using a HashMap in Java to count 
 * the frequency of each letter in a given sentence. 
 * Similar to how you learned to use a dictionary in Python 
 * for the same purpose, Java's HashMap is the equivalent tool for creating 
 * key-value pairs of letters and their counts. Your task is to implement 
 * the missing parts of the code to iterate through the sentence, consider 
 * only the alphabetical characters (use Character.isLetter()), convert all 
 * uppercase letters to lowercase, and update the letter count or 
 * add new letters into the HashMap.
 */

import java.util.HashMap;
import java.util.Map;

class Practice4 {
    // Function to count the frequency of each letter in a given sentence
    public static HashMap<Character, Integer> countLetterFrequency(String sentence) {
        HashMap<Character, Integer> letterCount = new HashMap<>();
        for (char letter : sentence.toCharArray()) {
            // TODO: If the character is a letter, update its count in the HashMap
            // or add it with a count of 1 if it's not already there
        	if (Character.isLetter(letter)) {
        		letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
        	}
        }
        return letterCount;
    }

    public static void main(String[] args) {
        String sentence = "Once upon a time in a faraway library";
        // TODO: Call the function with the sentence variable and print the result
        HashMap<Character, Integer> result = new HashMap<>();
        result = countLetterFrequency(sentence.toLowerCase());
        for (Map.Entry<Character, Integer> entry : result.entrySet()) {
        	System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}