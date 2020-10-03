package class_examples;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Avem un array cu N elemente și vrem să vedem dacă sunt 2 elemente distincte
 * în array, suma cărora este egală cu K (o valoare citită de la tastatură).
 * 
 * Două elemente se consideră distincte dacă sunt la poziții diferite. De
 * exemplu, pentru array-ul [1, 2, 3, 4, 5] și K = 9, răspunsul este DA.
 */
public class SumEqualsK
{
    public static void main(String[] args)
    {
        int[] numbers = { 1, 2, 3, 4, 5 };
        int sum = 9;

        System.out.println("With binary search:");
        findPairForSumWithBinarySearch(numbers, sum);

        System.out.println("================");

        System.out.println("With hash set:");
        findPairForSumWithHashSet(numbers, sum);
    }

    /**
     * Use binary search, because finally there is an opportunity for it:)
     * 
     * @param int[] numbers
     * @param int sum
     */
    private static void findPairForSumWithBinarySearch(int[] numbers, int sum)
    {
        /*
         * Sort numbers, iterate through them, binary search for sum-currentValue
         * 
         * Sort complexity: O(n log(n)) 
         * Iteration complexity: O(n) 
         * Binary search complexity: O(n log(n))
         */
        Arrays.sort(numbers);

        for (int i = 0, n = numbers.length; i < n; i++) {
            int pair = sum - numbers[i];
            int pairPosition = binarySearch(numbers, 0, n - 1, pair);

            if (pairPosition != -1) {
                System.out.println("We have a sum!");
                System.out.println("Number: " + numbers[i]);
                System.out.println("Pair: " + numbers[pairPosition]);
                System.out.println("Sum: " + sum);
                return;
            }
        }

        System.out.println("We do not have a sum!");
    }

    /**
     * Performs binary search for x in given array
     * @param int[] arr
     * @param int left
     * @param int right
     * @param int x
     * @return
     */
    private static int binarySearch(int arr[], int left, int right, int x)
    {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            /*
             * Found it!
             */
            if (arr[mid] == x)
                return mid;

            /*
             * Elements smaller than middle are to the left.
             */
            if (arr[mid] > x) {
                return binarySearch(arr, left, mid - 1, x);
            }

            /*
             * Elements bigger than middle are to the right
             */
            return binarySearch(arr, mid + 1, right, x);
        }

        /*
         * Element is not present in array at all.
         */
        return -1;
    }

    /**
     * @param int[] numbers
     * @param int sum
     */
    private static void findPairForSumWithHashSet(int[] numbers, int sum)
    {
        /*
         * O(n)
         */
        HashSet<Integer> set = convertToSet(numbers);

        /*
         * Add numbers to set, iterate through them, check if set contains pair.
         * 
         * O(n) to iterate
         * O(1) to get pair
         */
        for (int i = 0, n = numbers.length; i < n; i++) {
            int pair = sum - numbers[i];
            if (set.contains(pair)) {
                System.out.println("We have a sum!");
                System.out.println("Number: " + numbers[i]);
                System.out.println("I'd print the pair but I can't get it");
                System.out.println("Sum: " + sum);
                return;
            }

        }
    }

    /**
     * @param int numbers
     * @return HashSet<Integer>
     */
    private static HashSet<Integer> convertToSet(int[] numbers)
    {
        HashSet<Integer> result = new HashSet<Integer>();

        for(int i: numbers) {
            result.add(i);
        }

        return result;
    }
    
    /**
     * @param int[] numbers
     * @param sum
     */
    private static void findPairForSumWithForLoops(int[] numbers, int sum)
    {
        // nested fors: O(n^2).
    }
}
