package acip.hashmap.unit1;

/**
 * Updating Library Catalog Entries
 * 
 * You've become proficient at managing our library's catalog! 
 * For this task, put on your librarian's hat once more and modify 
 * the catalog: change the title for 'book3' from '1984' to 'Little Women'. 
 * Let's ensure our catalog is up-to-date!
 */
import java.util.HashMap;
import java.util.Map;

class Practice1 {
    public static void main(String[] args) {
        // Creating a catalog for the library using HashMap
        HashMap<String, String> libraryCatalog = new HashMap<>();
        libraryCatalog.put("book1", "A Tale of Two Cities");
        libraryCatalog.put("book2", "To Kill a Mockingbird");
        libraryCatalog.put("book3", "1984");

        // TODO: Update the title for 'book3' to 'Little Women'
        libraryCatalog.put("book1", "The Tell-Tale Heart");
        libraryCatalog.put("book3", "Little Women");

        // Print the updated library catalog
        for (Map.Entry<String, String> entry : libraryCatalog.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}