package class_examples;
import java.util.Arrays;
import java.util.PriorityQueue;

import util.Interval;

/**
 * La conferința anuală a persoanelor antisociale în sala unde se țin
 * prezentările este un șir de N scaune, pe care se vor așeza K persoane. 
 * 
 * Fiind antisocială, fiecare persoană când se așează vrea să fie cât de departe se
 * poate de restul persoanelor. Deci, fiecare persoană caută cea mai lungă
 * secvență continuă de scaune libere, și se așează la scaunul din mijlocul
 * secvenței. Fiecare persoană are o preferință care specifică dacă aceasta va
 * ocupa scaunul din stânga sau dreapta, în caz că secvența are un număr par de
 * scaune (la număr impar de scaune nu contează preferința, mijlocul e un singur
 * scaun). Dacă există mai multe secvențe de lungime maximă, persoana alege
 * prima din stânga spre dreapta. Se dă numărul de scaune (N), numărul de
 * persoane (K), o secvență formată din K litere de S (stânga) sau D (dreapta)
 * reprezentând preferințele persoanelor. Specificați pentru fiecare persoană ce
 * scaun va ocupa. 
 * 
 * De exemplu, dacă avem 5 scaune și 3 persoane, cu preferințele
 * DSD, prima persoană va ocupa scaunul 3, persoana a 2-a va ocupa scaunul 1,
 * iar persoana a 3-a va ocupa scaunul 5. 
 * 
 * Daca sunt 20 de scaune si 7 persoane
 * cu preferintele „DSDDDDS”, scaunele ocupate (în ordine) vor fi: 
 * 11, 5, 16, 8, 3, 14, 18.
 *
 */
public class AntisocialConference
{
    public static void main(String[] args)
    {
        System.out.println("Test 1:");
        printSeatingArrangements(5, 3, "DSD");
        
        System.out.println("Test 2:");      
        printSeatingArrangements(20, 7, "DSDDDDS");
    }
    
    private static void printSeatingArrangements(int numberOfChairs, int peopleToSeat, String preferences)
    {
        int[] chairs = new int[numberOfChairs];
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>();
        
        /*
         * The first interval to consider are all the chairs.
         */
        queue.add(new Interval(0, numberOfChairs - 1));
        
        for (int i = 0; i < peopleToSeat; i++) {
            System.out.println("===============");
            
            /*
             * Get the first interval in the priority queue.
             * This will be either the longest available interval or the leftmost interval.
             */
            Interval goodInterval = queue.poll();
            int intervalLength = goodInterval.getLength();
            int intervalStart  = goodInterval.getStart();
            int intervalEnd    = goodInterval.getEnd();
            
            /*
             * Get the middle chair in the interval.
             */
            int middle = intervalLength / 2;
            if (intervalLength % 2 == 0 ) {
                /*
                 * An even interval means we must account for the person's preference.
                 * 
                 * If the person prefers to sit to the left, 
                 * we adjust the seating in that direction.
                 */
                Character preference = preferences.charAt(i);
                middle += preference == 'D' ? 0 : -1;
            }
            
            /*
             * Put the person in their preferred chair.
             */
            int index = intervalStart + middle;
            chairs[index] = 1;

            System.out.println(String.format("Person %s occupied seat %s", i+1, index+1));

            /*
             * Seating someone in their preferred chair has created 2 intervals,
             * one to their left and one to their right.
             * 
             * Both intervals must be added to the queue if they have a valid length.
             */
            int leftStart = intervalStart;
            int leftEnd = index - 1;
            
            if (leftEnd - leftStart > 0) {
                Interval left = new Interval(leftStart, leftEnd);
                queue.add(left);
            }
            
            int rightStart = index + 1;
            int rightEnd = intervalEnd;
            
            if (rightEnd - rightStart > 0) {
                Interval right = new Interval(rightStart, rightEnd);
                queue.add(right);
            }
        }

        System.out.println(Arrays.toString(chairs));
    }
}
