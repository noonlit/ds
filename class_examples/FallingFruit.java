package class_examples;

import java.util.Scanner;

/**
 * Casa lui Sam se găsește între 2 copaci: un măr și un portocal și amândoi
 * copaci produc multe fructe. Casa lui Sam se întinde între 2 puncte pe stradă,
 * punctele s și t, iar copacii se găsesc la punctele a și b. Mărul este în
 * stânga casei (deci a < s) și portocala este în dreapta casei (deci b > t).
 * Când un fruct cade dintr-un copac, el aterizează la o distanță d de la copac.
 * O valoare negativă înseamnă că fructul a căzut în stânga copacului, iar o
 * valoare pozitivă înseamnă că fructul a căzut în dreapta. Citind de la
 * tastatură valorile s, t, a și b, urmate de numărul de mere (și distanțele la
 * care merele au căzut față de copac) și numărul de portocale (și distanțele la
 * care portocalele au căzut față de copac) determinați câte fructe au căzut pe
 * casa lui Sam.
 */
public class FallingFruit
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        /* get coordinates for Sam's house */
        System.out.println("Where does Sam's house start? (int)");
        int leftBound = scanner.nextInt();

        System.out.println("Where does Sam's house end? (int)");
        int rightBound = scanner.nextInt();

        if (rightBound <= leftBound) {
            scanner.close();
            System.out.println("The house must be of a positive size :) ");
            return;
        }

        /* get coordinates for trees */
        System.out.println("Where is the apple tree? (int) The value must be < than " + leftBound);
        int appleTreePosition = scanner.nextInt();

        if (appleTreePosition > leftBound) {
            scanner.close();
            System.out.println("The apple tree must be to the left of the house. Try again.");
            return;
        }

        System.out.println("Where is the orange tree? (int) The value must be > than " + rightBound);
        int orangeTreePosition = scanner.nextInt();

        if (orangeTreePosition < rightBound) {
            scanner.close();
            System.out.println("The orange tree must be to the right of the house. Try again.");
            return;
        }

        /* get number of fallen apples */
        System.out.println("How many apples fell out of the apple tree?");
        int fallenApples = scanner.nextInt();

        int fruitWithinHouseBounds = 0;
        for (int i = 0; i < fallenApples; i++) {
            System.out.println("Where did apple " + i + " fall?");
            int relativeApplePosition = scanner.nextInt();
            int absoluteApplePosition = appleTreePosition + relativeApplePosition;

            /* did the apple fall within house bounds? */
            if (absoluteApplePosition > leftBound && absoluteApplePosition < rightBound) {
                fruitWithinHouseBounds++;
            }
        }

        /* get number of fallen oranges */
        System.out.println("How many oranges fell out of the orange tree?");
        int fallenOranges = scanner.nextInt();

        for (int i = 0; i < fallenOranges; i++) {
            System.out.println("Where did orange " + i + " fall?");
            int relativeOrangePosition = scanner.nextInt();
            int absoluteOrangePosition = orangeTreePosition + relativeOrangePosition;

            /* did the orange fall within house bounds? */
            if (absoluteOrangePosition > leftBound && absoluteOrangePosition < rightBound) {
                fruitWithinHouseBounds++;
            }
        }

        scanner.close();

        System.out.println(fruitWithinHouseBounds + " fruit fell on top of poor Sam's house.");
    }
}
