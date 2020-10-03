package homework;

import java.util.Scanner;

/**
 * Elena locuiește pe o altă planetă pe care un an este alcătuit din N zile. Ea
 * trebuie să ajungă la o clădire care este la M km distanță față de locația ei
 * curentă. Ea pornește în prima zi a anului și ar vrea să ajungă cât mai repede
 * la clădirea respectivă, dar în fiecare zi a anului poate să parcurgă maximum
 * o anumită distanță (posibil diferită pentru zile diferite din an). Având
 * valori pentru M, N, și cele N distanțe care pot fi parcurse în zilele anului
 * (sub forma unui tablou de N elemente), determinați în a câta zi a anului va
 * ajunge Elena la destinația ei.
 * 
 * De exemplu: dacă N este 5 (sunt 5 zile într-un an), M este 23 și distanțele
 * care pot fi parcurse sunt [4, 9, 0, 1, 3], Elena va parcurge în prima zi 4
 * km, după a 2-a zi 13 km, după a 3-a zi tot 13 km, după a 4-a zi 14 km, după a
 * 5-a zi 17 km (aici se termină anul și începem an nou) după prima zi (a anului
 * nou) 21 km și în a 2-a zi ajunge la destinație. Deci răspunsul este că Elena
 * ajunge la destinație în a 2-a zi a anului (nu contează că a trecut un an de
 * când a plecat).
 * 
 * Va trebui să implementați 2 funcții: prima funcție primește ca parametru
 * numerele N, M și un tablou cu N elemente reprezentând distanțele care pot fi
 * parcurse în fiecare zi. Funcția trebuie să returneze în a câta zi a anului
 * ajunge Elena la destinație.
 * 
 * A 2-a funcție citește valoarea N și un tablou cu N elemente reprezentând
 * distanțele care pot fi parcurse în fiecare zi. După aceea funcția citește pe
 * rând valori pentru M (până când valoarea 0 este introdusă) și afișează în ce
 * zi ajunge Elena la o destinație la M km distanță.
 * 
 * Presupunem că pentru fiecare valoare M, ea pornește la drum în prima zi a
 * anului.
 */
public class DaysToDestination
{
    public static void main(String[] args)
    {
        int daysInYear = 5;
        int totalDistance = 23;
        int[] distancePerDay = { 4, 9, 0, 1, 3 };

        /*
         * first function
         */
        int day = getDayWhenDestinationIsReached(daysInYear, totalDistance, distancePerDay);
        System.out.println(String.format("Elena will reach her destination on day %d.", day));

        /*
         * second function
         */
        printDayDestinationIsReached();
    }
    
    private static int getDayWhenDestinationIsReached(int daysInYear, int totalDistance, int[] distancesPerDay)
    {
        int dayWhenDestinationIsReached = 0;
        
        int index = 0;
        while (totalDistance > 0) {
            /*
             * Get the distance Elena can travel in a day,
             * accounting for the trip taking longer than 1 year
             */
            int dayIndex = index % daysInYear;
            totalDistance -= distancesPerDay[dayIndex];
            
            dayWhenDestinationIsReached++;
            index++;
        }
        
        return dayWhenDestinationIsReached % daysInYear;
    }
    
    private static void printDayDestinationIsReached()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many days in a year?");
        int daysInYear = scan.nextInt();
        
        int[] distancePerDay = new int[daysInYear];
        for (int i = 0; i < daysInYear; i++) {
            System.out.println(String.format("How far can you travel on day %d?", i+1));
            int distance = scan.nextInt();
            distancePerDay[i] = distance;
        }
        
        System.out.println("How far is Elena going?");
        int distance = scan.nextInt();
        while (distance > 0) {
            int dayWhenDestinationIsReached = getDayWhenDestinationIsReached(daysInYear, distance, distancePerDay);
            System.out.println(String.format("Elena will reach her destination on day %d.", dayWhenDestinationIsReached));
            
            distance = scan.nextInt();
        }
        
        scan.close();
    }
}
