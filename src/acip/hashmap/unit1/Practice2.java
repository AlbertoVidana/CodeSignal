package acip.hashmap.unit1;
/**
 * Fix the LibraryCatalog HashMap
 * 
 * Here is a block of code that's intended to exhibit the title of a certain book from a library catalog. 
 * However, it contains a flaw preventing it from displaying the right title. 
 * Can you identify the problem and correct it to ensure it prints 
 * the accurate book title? Let's see you apply what you've just learned about HashMap in Java!
 */
import java.util.HashMap;
import java.util.Map;

class Practice2 {
    public static void main(String[] args) {
        // Simple HashMap example to catalog books and print a specific book title
        HashMap<String, String> libraryCatalog = new HashMap<>(Map.of(
            "book1", "The Little Prince",
            "book2", "The Hobbit",
            "book3", "The Catcher in the Rye"
        ));

        // Access and print the title of book2 from the catalog
        System.out.println(libraryCatalog.get("book2"));
    }
}