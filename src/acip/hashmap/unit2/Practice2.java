package acip.hashmap.unit2;

/**
 * Fix the Book Counter Code
 * 
 * After implementing a system to track the number of copies of each book title in the library, 
 * something doesn't seem right with the output. 
 * Review the code and correct it so that it accurately reflects the count of each book.
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

class Practice2 {
    public static void main(String[] args) {
        // Create a HashMap to count the copies of books in a library
        HashMap<String, Integer> bookMap = new HashMap<>();

        // List of books to count
        ArrayList<String> books = new ArrayList<>();
        books.add("The Hobbit");
        books.add("The Hobbit");
        books.add("The Lion King");
        books.add("The Hobbit");
        books.add("Cinderella");

        // Counting the number of each book in the list
        for (String book : books) {
        	//Solution
        	bookMap.put(book, bookMap.getOrDefault(book, 0) + 1);
//        	
//            if (bookMap.containsKey(book)) {
//                bookMap.put(book, bookMap.get(book) + 2);
//            } else {
//                bookMap.put(book, 1);
//            }
        }

        // Print the HashMap to see how many copies of each book we have
        for (Map.Entry<String, Integer> entry : bookMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}