package homework;

/**
 * Se dau 2 numere, N (1 < N < 999.999.999) și K (1 <= K <= 6). Găsiți cel mai
 * mare număr posibil care poate fi format schimbând maxim K cifre din N cu
 * orice altă cifră (aleasă de voi). De exemplu, dacă N = 44832 și K = 2, cel
 * mai mare număr care poate fi format schimbând maxim 2 cifre din 44832 este
 * 99832.
 */
public class MaxNumber
{
    public static void main(String[] args)
    {
        System.out.println("Results with string cast:");
        System.out.println(getMaxNumber(44832, 2));
        System.out.println(getMaxNumber(94832, 2));
        System.out.println(getMaxNumber(991111, 3));
        System.out.println(getMaxNumber(123, 3));
        
        System.out.println("Results with math:");
        System.out.println(getMaxNumberWithMath(44832, 2));
        System.out.println(getMaxNumber(94832, 2));
        System.out.println(getMaxNumber(991111, 3));
        System.out.println(getMaxNumber(123, 3));
    }
    
    /**
     * Returns the highest number that the given number can be converted to
     * given the amount of allowed changes.
     * 
     * @param number
     * @param allowedChanges
     * @return
     */
    private static int getMaxNumber(int number, int allowedChanges)
    {
        String numberAsString = String.valueOf(number);
        String result = "";
        
        int performedChanges = 0;
        for (int i = 0, n = numberAsString.length(); i < n; i++) {
            char currentChar = numberAsString.charAt(i);
            
            if (currentChar == '9') {
                result += '9';
                continue;
            }
            
            if (performedChanges < allowedChanges) {
                result += '9';
                performedChanges++;
                continue;
            }
            
            result += currentChar;
        }
        
        return Integer.parseInt(result);
    }
    
    /**
     * Returns the highest number that the given number can be converted to
     * given the amount of allowed changes.
     * 
     * @param number
     * @param allowedChanges
     * @return
     */
    private static int getMaxNumberWithMath(int number, int allowedChanges)
    {
        int result = 0;
        int digits = 0;
        int performedChanges = 0;
        
        /*
         * Get count of digits by repeated integer division with 10
         */
        int copy = number;
        while (copy > 0) {
            copy = copy / 10;
            digits++;
        }
        
        /*
         * Build result by repeated integer division with powers of 10.
         * 
         * The first digit is the number divided by 10^(one less than its digits).
         * E.g. 45678 / 10^4 = 4
         */
        int magnitude = (int) Math.pow(10, digits-1);
        while (magnitude > 0) {
            int current = number / magnitude;
            
            /*
             * Decrement number to prepare for next iteration
             * 
             * E.g. turn number from 45678 to 5678 
             */
            number -= current * magnitude;
            
            if (current == 9) {
                result += 9 * magnitude;
                magnitude = magnitude / 10;
                continue;
            }
            
            if (performedChanges < allowedChanges) {
                result += 9 * magnitude;
                magnitude = magnitude / 10;
                performedChanges++;
                continue;
            }
            
            result += current * magnitude;
            magnitude = magnitude / 10;
        }
        
        /*
         * Treat last digit, which was left out in the loop
         */
        result += number;
        
        return result;
    }
}
