package class_examples;

import java.util.Scanner;

/**
 * Paul e mare fan F1. În timp ce se uita la cursa din India el a observat că
 * pista conține o secție lungă de drum drept, dar care este prea îngustă pentru
 * depășiri. Astfel, o mașină trebuia să încetinească dacă avea o mașină cu
 * viteză mai mică în față. În timp ce se uita la cursă, Paul se întreba oare
 * câte mașini merg cu viteza lor maximă. Dată fiind viteza maximă posibilă
 * pentu N mașini care merg una după alta pe pistă, determinați câte merg cu
 * viteza lor maximă. O mașină merge cu viteza ei maximă dacă nu are nicio
 * mașină cu viteză mai mică în față. Dacă are în față o mașină cu viteză mai
 * mică, atunci va merge cu aceeași viteză ca și mașina din față. Dacă vitezele
 * maxime sunt [4, 5, 1, 2, 3] sunt 2 mașini care merg cu viteza maximă: prima
 * și a 3-a.
 */
public class FastCars
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        /*
         * Get cars count.
         */
        System.out.println("How many cars are there?");
        int cars = scanner.nextInt();

        /*
         * Get speeds for cars.
         */
        int[] speeds = new int[cars];
        for (int i = 0; i < cars; i++) {
            System.out.println("How fast is the " + i + "th car going?");
            speeds[i] = scanner.nextInt();
        }

        scanner.close();

        /*
         * The first car is going with its max speed by default, as there is nothing in
         * front of it.
         */
        int count = 1;
        System.out.println("Car 0 is going with its maximum speed.");

        /*
         * The first car's speed represents the initial limitation.
         */
        long speedLimitation = speeds[0];

        for (int i = 1; i < cars; i++) {
            // Is the car in front faster than the current car?
            // If so, the current one is going at maximum speed.
            if (speedLimitation >= speeds[i]) {
                System.out.println("Car " + i + " is going at its maximum speed.");
                count++;
            }

            speedLimitation = speeds[i];
        }

        System.out.println(count + " cars are doing their best.");
    }
}
