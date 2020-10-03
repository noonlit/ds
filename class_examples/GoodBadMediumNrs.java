package class_examples;
import java.util.HashSet;

/**
 * Avem un array cu N elemente și trebuie să spunem dacă acel array este BUN,
 * MEDIU sau RĂU. 
 * 
 * Dacă array-ul conține exact X elemente distincte, el este BUN,
 * dacă conține mai puțin de X elemente distincte, el este RĂU 
 * iar dacă conține mai mult de X elemente distincte, array-ul este MEDIU. 
 * 
 * De exemplu, array-ul [5, 2, 3, 4, 2, 1, 5] și X = 3 este MEDIU.
 * 
 * De rezolvat in 2 feluri.
 */
public class GoodBadMediumNrs
{
    public static void main(String[] args)
    {
        int[] numbers = { 5, 2, 3, 4, 2, 1, 5 };
        int x = 3;
        System.out.println(String.format("The vector contains %d elements", numbers.length));
        
        System.out.println("With hash set, as God intended:");
        hashSetImplementation(numbers, x);
        
        System.out.println("================");
        
        System.out.println("With nested for loop:");
        forImplementation(numbers, x);
    }
    
    /**
     * O(n^2)
     * 
     * Could go down to O(n) if the array were sorted.
     * 
     * @param int[] numbers
     * @param int x
     */
    private static void forImplementation(int[] numbers, int x)
    {
        int distinctNumbers = 1;
        int n = numbers.length;
        
        for (int i = 1; i < n; i++)  
        { 
            int j; 
            for (j = 0; j < i; j++) {
                /*
                 * Duplicate found, stop comparison.
                 */
                if (numbers[i] == numbers[j]) {
                    break; 
                }
            }

            /*
             * We got all the way to i (the number to compare)
             * without finding a duplicate.
             */
            if (i == j) {
                distinctNumbers++;
            }   
        } 
        
        System.out.println(String.format("The vector contains %d distinct elements", distinctNumbers));
        if (distinctNumbers == x) {
            System.out.println("GOOD");
            return;
        }
        
        if (distinctNumbers < x) {
            System.out.println("BAD");
            return;
        }
        
        System.out.println("MEDIUM");
        return; 
    }
    
    /**
     * Complexity is O(n), because of the loop to convert to set.
     * The add() and size() are O(1).
     * 
     * @param int[] numbers
     * @param int x
     */
    private static void hashSetImplementation(int[] numbers, int x)
    {
        HashSet<Integer> numbersSet = convertToSet(numbers);
        int setLength = numbersSet.size();
        System.out.println(String.format("The vector contains %d distinct elements", setLength));
        
        if (setLength == x) {
            System.out.println("GOOD");
            return;
        }
        
        if (setLength < x) {
            System.out.println("BAD");
            return;
        }
        
        System.out.println("MEDIUM");
        return; 
    }
    
    /**
     * Converts an array of integers to a set.
     * 
     * We can notice that add() method of HashSet class internally calls put() method of backing HashMap object 
     * by passing the element you have specified as a key and constant “PRESENT” as its value.
     * 
     * So amortize (average or usual case) 
     * time complexity for add, remove and look-up (contains method) operation of HashSet takes O(1) time.
     * 
     * @param int[] numbers
     * @return HashSet<Integer>
     */
    private static HashSet<Integer> convertToSet(int[] numbers)
    {
        HashSet<Integer> result = new HashSet<Integer>();

        for (int i = 0, n = numbers.length; i < n; i++) {
            result.add(numbers[i]);
        }

        return result;
    }
}
