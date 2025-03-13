package src.acip.hashmap.unit4;

/**
 * 
 * In our library catalog system, ensure that a book's available 
 * copies are decremented only when copies are available. 
 * Modify the code to check if more than 0 copies are available before decreasing. 
 * This introduces a practical use of conditional statements in real-world tasks using Java.
 */

import java.util.HashMap;

class Practice1 {
    public static void main(String[] args) {
        // HashMap to hold the library catalog system
        HashMap<String, HashMap<String, Integer>> libraryCatalog = new HashMap<>();
        
        // Example: Adding a book
        HashMap<String, Integer> bookInfo = new HashMap<>();
        bookInfo.put("copies", 3);
        libraryCatalog.put("978-3-16-148410-0", bookInfo);
        
        // Example: Borrowing a book (decrementing the number of copies)
        for (int i = 0; i < 4; i++) {
            if (libraryCatalog.get("978-3-16-148410-0").get("copies") > 0) {
                libraryCatalog.get("978-3-16-148410-0").put("copies", libraryCatalog.get("978-3-16-148410-0").get("copies") - 1);   
            }
        }
        
        // Print the number of copies left
        System.out.println("Copies left: " + libraryCatalog.get("978-3-16-148410-0").get("copies"));
    }
}