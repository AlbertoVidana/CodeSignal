/**
 * You are given a string, and your task is to check whether 
 * the provided string is a palindrome, without using any 
 * built-in string methods. A string is a palindrome 
 * if it reads the same forward and backward, ignoring 
 * the casing of letters ('A' and 'a' are considered the same) 
 * and ignoring non-letter characters.
 * Return a boolean value: true if the string is a palindrome and false if it is not.
 * It is not allowed to use Java built-in functions 
 * like StringBuilder.reverse(), String.toLowerCase(), or similar in this task.
 */

 public class Solution {
    // TODO: Implement the function to check whether the provided string is a palindrome or not.
    public boolean isPalindrome(String inputString) {
        System.out.println(inputString);
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if (Character.isLetterOrDigit(currentChar)) {
                s.append(currentChar);
            }
        }
        
        System.out.println(s);
        for (int i = 0; i < s.length() / 2; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt((s.length()-1) - i);
            if (c1 >= 'A' && c1 <= 'Z') c1 = (char) (c1 + 32);
            if (c2 >= 'A' && c2 <= 'Z') c2 = (char) (c2 + 32);
            if (c1 == c2) continue;
            else return false;
        }
        return true;
    }
}