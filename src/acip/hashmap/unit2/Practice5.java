package acip.hashmap.unit2;

/**
 * Counting Book Titles Using HashMap in Java
 * 
 * You've been introduced to counting occurrences using HashMap in Java. 
 * Your task now is to efficiently count a collection of your favorite 
 * book titles, where duplicates may be present. You aim to track 
 * the total count for each title in the collection.
 */
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

class Practice5 {
    public static void main(String[] args) {
        // Create and initialize an ArrayList 'books' with some duplicated book titles of your choice
        // TODO: YOUR CODE HERE
    	 ArrayList<String> books = new ArrayList<>();
         books.add("1984");
         books.add("The casher in the ride");
         books.add("The Borjias");
         books.add("1984");
         books.add("The power of belive");
         books.add("48 Rules of Power");

        // Create an empty HashMap 'bookCount' to store the count of each book
        // TODO: YOUR CODE HERE
         HashMap<String, Integer> bookCount = new HashMap<>();

        // Loop through each book in the 'books' list and count the occurrences
        // TODO: Check if the book is already in HashMap, if so increment its count, otherwise add it with count 1
         for (String book : books) {
        	 bookCount.put(book, bookCount.getOrDefault(book, 0) + 1);
         }

        // Finally, print the 'bookCount' HashMap
        // TODO: YOUR CODE HERE
         for (Map.Entry<String, Integer> entry : bookCount.entrySet()) {
        	 System.out.println(entry.getKey() + " " + entry.getValue());
         }
    }
}