package src.acip.hashmap.unit4;

/**
 * 
 * You've already seen how powerful HashMaps are with our examples. 
 * Now, it's time to put your Java skills to the test with a Library Management System task. 
 * Your job is to check the availability of a specific book in the library. 
 * HashMaps in Java make it quite easy to manage such tasks. 
 * Show us what you've got and complete this challenge using your knowledge of HashMaps!
 */
import java.util.HashMap;
import java.util.Map;

class Practice5 {
    public static void main(String[] args) {
        // TODO: Define a 'libraryCatalog' using HashMap with a few books. 
        // Each book id as key and another HashMap as value containing details like title, author, and year_published
        HashMap<String, HashMap<String, String>> libraryCatalog = new HashMap<>();
        
        HashMap<String, String> bookDetails = new HashMap<>();
        String bookId = "1234";
        bookDetails.put("title", "The power of belive");
        bookDetails.put("author", "Lipthon");
        bookDetails.put("year_published", "2015");
        
        libraryCatalog.put(bookId, bookDetails);
        // TODO: Assign a 'bookId' variable with the id of the book you want to check
        bookId = "1234";
        // TODO: Implement a search in 'libraryCatalog' to check if the 'bookId' exists and print the book details or "Book not found in the library catalog."
        if (libraryCatalog.containsKey(bookId)) {
            System.out.println("Title: " + libraryCatalog.get(bookId).get("title") +
                                ", Author: " + libraryCatalog.get(bookId).get("author") +
                                ", Year Published: " + libraryCatalog.get(bookId).get("year_published"));
        } else {
            System.out.println("No book found.");
        }
    }
}