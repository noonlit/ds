package homework;

import java.util.Arrays;

/**
 * Se dă un tablou/vector/array A cu N numere naturale (1 < N < 1.000.000,
 * fiecare element din A este între 1 și 100 inclusiv).
 * 
 * Verificați dacă toate numerele dintre minimul și maximul din A se găsesc în
 * A. De exemplu, dacă N = 6 și A este [10, 7, 9, 9, 8, 11], răspunsul este Da
 * (minimul este 7, maximul este 11, și toate numerele între 7 și 11 – 8, 9, 10
 * – se găsesc în A).
 * 
 * Pentru N = 6 și A = [5, 4, 2, 4, 6, 7] răspunsul este Nu (minimul e 2,
 * maximul e 7, dar nu toate numerele dintre 2 și 7 se găsesc în A).
 */
public class NumbersBetweenMinAndMax
{
    public static void main(String[] args)
    {
        int[] valid = { 10, 7, 9, 9, 8, 11 };
        String isValid = containsAllBetweenMinAndMax(valid) ? "valid" : "not valid";
        System.out.println("Sequence " + Arrays.toString(valid) + " is " + isValid);
        
        int[] invalid = { 5, 4, 2, 4, 6, 7 };
        isValid = containsAllBetweenMinAndMax(invalid) ? "valid" : "not valid";
        System.out.println("Sequence " + Arrays.toString(invalid) + " is " + isValid);
    }
    
    /**
     * Checks whether the given array contains all numbers between its min and its max.
     * 
     * @param values
     * @return
     */
    private static boolean containsAllBetweenMinAndMax(int[] values)
    {
        Arrays.sort(values);
        
        for (int i = 0, n = values.length - 1; i < n; i++) {
            // the current number is allowed to be the same as the previous OR the same + 1
            if ((values[i+1] - values[i]) > 1) {
                return false;
            }
        }
        
        return true;
    }
}
