package src.acip.hashmap.unit4;

/**
 * 
 * There seems to be an issue when attempting to display book information 
 * by its ID in our library catalog system written in Java. Can you identify and 
 * resolve it to ensure the book details are correctly printed? Analyze 
 * the code and perform the necessary fix. The code is expected to print 
 * the book information by id or report that the book is not in the catalog.
 */

import java.util.HashMap;
import java.util.Map;

class Practice2 {
    private static Map<String, Map<String, String>> libraryCatalog = new HashMap<String, Map<String, String>>() {{
        put("001", new HashMap<String, String>() {{
            put("title", "Wonder");
            put("author", "R.J. Palacio");
            put("year_published", "2012");
        }});
        put("002", new HashMap<String, String>() {{
            put("title", "Charlotte's Web");
            put("author", "E.B. White");
            put("year_published", "1952");
        }});
    }};

    // Function to display book information by ID
    public static void showBookInfo(String bookId) {
        if (libraryCatalog.containsKey(bookId)) {
            System.out.println("Title: " + libraryCatalog.get(bookId).get("title") + ", Author: " + libraryCatalog.get(bookId).get("author") +
                           ", Year Published: " + libraryCatalog.get(bookId).get("year_published"));
        } else {
            System.out.println("No book found.");                    
        }
    }

    public static void main(String[] args) {
        // Display the info for book ID '001'
        showBookInfo("001");
        // Attempt to display info for a book ID that doesn't exist
        showBookInfo("003");
    }
}