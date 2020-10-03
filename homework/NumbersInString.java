package homework;

/**
 * Pentru un string calculați numărul de numere aflate în string. De exemplu,
 * stringul sadw96aeafae4awdw2wd100awd conține 4 numere: 96, 4, 2, 100.
 */
public class NumbersInString
{
    public static void main(String[] args)
    {
        String string = "sadw96aeafae4awdw2wd100awd789ax0";
        System.out.println("The string " + string + " contains " + getNumbersCount(string) + " numbers");
    }
    
    /**
     * Counts the numbers in a given string and returns the count.
     * 
     * @param String string
     * @return int
     */
    private static int getNumbersCount(String string) 
    {
        boolean previousWasNumber = false;
        int numbersCount = 0;

        for (int i = 0, n = string.length(); i < n; i++) {
            boolean currentIsNumber = characterIsNumber(string.charAt(i));

            /*
             * Check if this is first number in a sequence.
             */
            if (currentIsNumber && !previousWasNumber) {
                numbersCount++;
            }

            /*
             * Set state for next iteration.
             */
            previousWasNumber = currentIsNumber;
        }
        
        return numbersCount;
    }

    /**
     * Checks whether the given char is in the 0-9 range.
     * 
     * @param character
     * @return
     */
    private static boolean characterIsNumber(char character)
    {
        return character >= '0' && character <= '9';
    }
}
