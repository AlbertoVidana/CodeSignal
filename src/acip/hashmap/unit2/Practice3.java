package acip.hashmap.unit2;

/**
 * Counting Returned Books Using HashMap in Java
 * 
 * Now, let's make a slight tweak to the scenario. Imagine that a few new books 
 * have been added to the library, and your task is to update their counts. 
 * You need to fill in the missing code to accurately count these new additions. 
 * Ensure the output reflects the updated counts for a small set of new returns.
 */

import java.util.HashMap;
import java.util.ArrayList;

class Practice3 {
    public static void main(String[] args) {
        HashMap<String, Integer> bookCounts = new HashMap<>();
        ArrayList<String> returnedBooks = new ArrayList<>();
        returnedBooks.add("Mystery at the Mansion");
        returnedBooks.add("Space Odyssey");
        returnedBooks.add("Mystery at the Mansion");
        returnedBooks.add("Java Programming");

        // Loop through the returnedBooks list
        for (String book : returnedBooks) {
            // TODO: Update bookCounts with the right counts for each book
            bookCounts.put(book, bookCounts.getOrDefault(book, 0) + 1);
        }

        // Output the HashMap with the count of books
        for (String key : bookCounts.keySet()) {
            System.out.println(key + ": " + bookCounts.get(key));
        }
    }
}