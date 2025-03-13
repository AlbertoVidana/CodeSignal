package src.acip.hashmap.unit4;

/**
 * 
 * Use your knowledge from the lesson to count and display 
 * the number of appearances for each specified word in a provided 
 * string using Java. You'll need to analyze the string and update 
 * the HashMap accordingly to track the word counts.
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        HashMap<String, Integer> wordCounts = new HashMap<>();  // Initialize a HashMap to store the word counts

        // Array of words to count
        String[] wordsToCount = {"apple", "banana", "cherry"};

        // String in which to count words
        String stringToSearch = "apple banana apple cherry apple banana";

        // Split the string into individual words
        String[] words = stringToSearch.split(" ");

        for (String word : words) {
            // TODO: Count the appearances of each word in the string
            // and update wordCounts accordingly
        	wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // Output the counts of each word
        for (String wordToCount : wordsToCount) {
            System.out.println(wordToCount + ": " + wordCounts.getOrDefault(wordToCount, 0));
        }
    }
}