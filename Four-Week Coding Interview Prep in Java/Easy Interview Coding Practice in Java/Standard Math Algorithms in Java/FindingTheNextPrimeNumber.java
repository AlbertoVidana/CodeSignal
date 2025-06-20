/**
 * You are given an integer number, 1≤n≤1061≤n≤106. 
 * Your task is to write a function nextPrime(n), that 
 * takes an integer n as input and returns the smallest prime number larger than n.
 * Here are some examples:
 * nextPrime(7) should return 11, because 11 is the next prime number after 7.
 * nextPrime(13) should return 17, because 17 is the next prime number after 13.
 * nextPrime(50) should return 53, because 53 is the next prime number after 50.
 */

public class FindingTheNextPrimeNumber {
     public int nextPrime(int n) {
        // TODO: implement the function to find the next prime number after n
        int num = n + 1;
        while (!isPrime(num)) {
            num++;
        }
        return num;
    }
    
     public static boolean isPrime(int num) {
       if (num <= 1) {
           return false;
       }
       for (int i = 2; i <= Math.sqrt(num); i++) {
           if (num % i == 0) {
               return false;
           }
       }
       return true;
   }
}
