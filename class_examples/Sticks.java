package class_examples;

import java.util.Scanner;
import java.util.Vector;

/**
 * N sticks with length > 0
 * 
 * Repeatedly reduce sticks length by shortest stick and outputs
 * - number of sticks cut 
 * - result of operation
 * every time.
 */
public class Sticks
{
    public static void main(String[] args)
    {
        Vector<Integer> sticks = getInput();
        System.out.println("Original vector:");
        printVectorValues(sticks);

        int sticksLeft = sticks.size();

        do {
            int smallestLength = getMin(sticks);
            // System.out.println("Current min is: " + smallestLength);
            int sticksCut = 0;

            /*
             * Reduce the sticks by the smallest stick length. The length cannot be reduced
             * below 0.
             */
            for (int i = 0; i < sticks.size(); i++) {
                int current = sticks.get(i);

                /*
                 * There is no operation to perform if the stick is gone :)
                 */
                if (current == 0) {
                    continue;
                }

                /*
                 * Case: the stick is reduced by its entire length.
                 */
                if (current - smallestLength <= 0) {
                    sticks.set(i, 0);
                    sticksCut++;
                    sticksLeft--;
                    continue;
                }
                
                /*
                 * Case: the stick is reduced by a fraction of its length.
                 */
                sticks.set(i, current - smallestLength);
                sticksCut++;
            }

            System.out.println("Result:");
            printVectorValues(sticks);
            System.out.println("We made this many cuts: " + sticksCut);
        } while (sticksLeft > 0);
    }

    /**
     * Gets the input for the problem.
     * 
     * @return
     */
    private static Vector<Integer> getInput()
    {
        System.out.println("How many stick lengths?");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        Vector<Integer> sticks = new Vector<Integer>(count);
        for (int i = 0; i < count; i++) {
            System.out.println("Give me the next length (" + (i + 1) + "/" + count + ")");
            sticks.add(scanner.nextInt());
        }

        scanner.close();

        return sticks;
    }

    /**
     * Prints vector (excluding 0)
     * 
     * @param Vector<Integer> vector
     */
    private static void printVectorValues(Vector<Integer> vector)
    {
        System.out.print("{");
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i) == 0) {
                continue;
            }
            
            System.out.print(" " + vector.get(i) + " ");
        }
        System.out.print("}\n");
    }

    /**
     * Returns min of vector (excluding 0)
     * 
     * @return Integer
     */
    private static Integer getMin(Vector<Integer> numbers)
    {
        int min = Integer.MAX_VALUE;

        for (Integer i : numbers) {
            min = (i == 0) ? min : Math.min(min, i);
        }

        return min;
    }
}
