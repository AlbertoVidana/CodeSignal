/**
 * Your task is to create a Java function called getPrimeFactors(int n) 
 * that will return all unique prime factors of an integer n in a list. 
 * A prime factor of n is a prime number that divides n without leaving a remainder. 
 * The expected complexity is O((n))O((​n)).
 * Note that returned prime factors should be unique and sorted 
 * in ascending order in the resulting list.
 */

public class UniquePrimeFactorsInJava {
    public List<Integer> getPrimeFactors(int n) {
        // TODO: Implement the function that returns all prime factors of n
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (n % 2 == 0) {
            map.put(2, map.getOrDefault(2, 0) +1);
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 2) {
           map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.add(entry.getKey());
        }
        Collections.sort(list);
        return list;
    }
}
