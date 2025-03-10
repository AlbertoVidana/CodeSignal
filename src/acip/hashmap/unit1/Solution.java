package acip.hashmap.unit1;
/**
 * Diving Deeper: Understanding Time Complexity

HashMaps are popular because they save time! Operations like adding, updating, 
and locating elements take average constant time, O(1), which means they require 
nearly the same amount of time regardless of the library size.

However, to fully understand this, let's delve into the concept of hash functions 
and the difference between average-case and worst-case scenarios.

Hash Functions: A hash function takes an input (or "key") and returns a fixed-size 
string of bytes. The output is typically a numerical value (hashcode) that 
represents the original string. The idea is to distribute keys evenly across 
the array to minimize hash collisions, where two different keys produce the same hashcode.

For example, hash("book1") might return 123 and hash("book2") might return 456.

Average-Case Scenario: In the average-case scenario, the hash function distributes 
keys uniformly across the HashMap. Thanks to this uniform distribution, the operations 
of adding, updating, or retrieving keys have a time complexity of O(1) because 
they involve a simple arithmetic operation and direct addressing.

Worst-Case Scenario: In the worst-case scenario, a poor hash function could cause 
too many collisions, making the HashMap resemble a linked list. When this happens, operations 
degrade to O(n) time complexity because they involve traversing a list of n elements. 
Java's HashMap handles collisions internally using a mechanism called separate 
chaining or, in some cases, tree-based structure to mitigate performance degradation.

Understanding the balance between these scenarios helps in selecting or designing an 
effective hash function to maintain the desired performance of O(1) in average cases.

By leveraging well-designed hash functions and recognizing potential pitfalls, 
you can maximize the efficiency and apply HashMaps effectively in your Java programs.
*/

import java.util.HashMap;

import java.util.Map;

class Solution {

    public static void main(String[] args) {

        // Creating a catalog for the library using HashMap with initialization
        Map<String, String> libraryCatalog = new HashMap<>(Map.of(
            "book1", "A Tale of Two Cities",
            "book2", "To Kill a Mockingbird",
            "book3", "1984"
        ));

        // Updating an existing book's title
        libraryCatalog.put("book1", "The Tell-Tale Heart");
        System.out.println("Updated book1: " + libraryCatalog.get("book1")); // Output: "Updated book1: The Tell-Tale Heart"

        // Adding a new book to the catalog
        libraryCatalog.put("book4", "Pride and Prejudice");
        System.out.println("Added book4: " + libraryCatalog.get("book4")); // Output: "Added book4: Pride and Prejudice"
    }
}