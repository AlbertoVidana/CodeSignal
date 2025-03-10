package acip.hashmap.unit1;
/**
 * Updating and Accessing Elements in a HashMap
 * 
 * Great job learning about HashMaps! Now, let's practice updating and accessing elements within a HashMap. 
 * Your task is to update the catalog with a new title for the key "mystery", and then print it out. 
 * Remember, updating and accessing elements are crucial operations in working with Java HashMap.
 */
import java.util.HashMap;

class Practice4 {
    public static void main(String[] args) {
        // Create a HashMap representing a small library catalog
        HashMap<String, String> libraryCatalog = new HashMap<>();
        libraryCatalog.put("mystery", "Sherlock Holmes");
        libraryCatalog.put("sci-fi", "Dune");
        libraryCatalog.put("fantasy", "Harry Potter");

        // TODO: Update the mystery book's title to 'Murder on the Orient Express' in the libraryCatalog
        libraryCatalog.put("mystery", "Murder on the Orient Express");        
        // TODO: Print the new title of the mystery book
        System.out.print(libraryCatalog.get("mystery"));
    }
}