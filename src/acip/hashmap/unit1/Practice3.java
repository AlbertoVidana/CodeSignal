package acip.hashmap.unit1;
/**
 * Check if a Book Exists in the Library Catalog
 * 
 * Check if a certain book exists in our library catalog using Java. 
 * If it does, print "Book is available". If not, print that it's not in the catalog. 
 * Use the HashMap operations for this task.
 */

import java.util.HashMap;

class Practice3 {
    public static void main(String[] args) {
        // Library Catalog
        HashMap<String, String> libraryCatalog = new HashMap<>();
        libraryCatalog.put("Moby Dick", "Herman Melville");
        libraryCatalog.put("The Great Gatsby", "F. Scott Fitzgerald");
        
        // TODO: Check if '1984' is in the libraryCatalog. If yes, print "Book is available". If no, print it's not in the catalog.
        if (libraryCatalog.get("1984") != null) {
            System.out.print("Book is available");
        } else {
            System.out.print("It's not in teh catalog");
        }
    }
}