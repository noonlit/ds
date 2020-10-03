package class_examples;

import java.util.Arrays;
import java.util.Stack;

/**
 * În cadrul unui carnaval, pe strada principală a orașului vor defila calesti
 * cu flori. Aceste calesti pornesc dintr-o stradă îngustă, în care încape un
 * singur rând de calesti (și nu este loc ca o caleasca să depășească o alta
 * caleasca).
 * 
 * Fiecare caleasca are un număr (de la 1 la N, unde N este numărul calestilor),
 * și organizatorii ar dori ca aceste calesti să defileze în ordinea numerelor
 * (prima dată caleasca 1, urmata de caleasca 2, etc.). Numai că aceste calesti
 * au intrat deja în strada de unde pornesc, într-o altă ordine. În stradă nu se
 * pot face depășiri, dar există o stradă laterală (tot foarte îngustă, în care
 * nu există posibilitatea depășirii), în care pot intra anumite calesti, ca să
 * lase pe cele din spate să treacă de ele.
 * 
 * Având un array cu ordinea inițială a celor N calesti de pe stradă, afișați un
 * mesaj dacă acestea pot ieși din stradă în ordinea numerelor.
 * 
 * De exemplu, dacă inițial calestile sunt în ordinea 5, 1, 2, 4, 3: 
 * - Caleasca 5 intră pe strada laterală 
 * - Caleasca 1 trece și iese pe stradă 
 * - Caleasca 2 trece și iese pe stradă 
 * - Caleasca 4 intră pe stradă laterală 
 * - Caleasca 3 trece și iese pe stradă 
 * - Caleasca 4 iese din strada laterală și iese pe stradă 
 * - Caleasca 5 iese din strada laterală și iese pe stradă 
 * Se poate ieși în așa fel încât calestile să fie în ordine crescătoare după numere. 
 * 
 * Dacă ordinea inițială a calestilor era 4, 1, 2, 5, 3: 
 * - Caleasca 4 intră pe strada laterală 
 * - Caleasca 1 trece și iese pe stradă 
 * - Caleasca 2 trece și iese pe stradă 
 * - Caleasca 5 intră pe stradă laterală 
 * - Caleasca 3 trece și iese pe stradă 
 * - Caleasca 4 ar trebui să iasă pe stradă, dar în strada laterală caleasca 5 e înaintea calestii 4, 
 * deci caleasca 4 nu poate ieși. 
 * Nu se poate ieși în așa fel încât calestile să fie în ordine crescătoare după numere.
 */
public class FlowerChariots
{

    public static void main(String[] args)
    {
        System.out.println("Should be able to proceed:");
        int[] chariots = new int[] { 5, 1, 2, 4, 3 };
        validateChariotsConfiguration(chariots);

        System.out.println("Should be unable to proceed:");
        chariots = new int[] { 4, 1, 2, 5, 3 };
        validateChariotsConfiguration(chariots);

        System.out.println("Should be able to proceed:");
        chariots = new int[] { 1, 2, 3, 5, 4 };
        validateChariotsConfiguration(chariots);

        System.out.println("Should be able to proceed:");
        chariots = new int[] { 5, 4, 3, 2, 1 };
        validateChariotsConfiguration(chariots);

        System.out.println("Should be able to proceed:");
        chariots = new int[] { 1, 2, 5, 4, 3 };
        validateChariotsConfiguration(chariots);

        System.out.println("Should be unable to proceed:");
        chariots = new int[] { 5, 3, 4, 1, 2 };
        validateChariotsConfiguration(chariots);

        System.out.println("Should be able to proceed:");
        chariots = new int[] { 5, 1, 3, 2, 4 };
        validateChariotsConfiguration(chariots);
    }

    private static void validateChariotsConfiguration(int[] chariots)
    {
        System.out.println(String.format("Current configuration: %s", Arrays.toString(chariots)));

        Stack<Integer> sideStreetChariots = new Stack<Integer>();

        int desiredNumber = 1;
        int position = 0;
        int maxChariotNumber = chariots.length;
        while (position < maxChariotNumber) {
            int currentChariotNumber = chariots[position];

            /*
             * Case: the chariot has the correct number and can proceed.
             */
            if (currentChariotNumber == desiredNumber) {
                desiredNumber++;
                position++;
                continue;
            }

            /*
             * Case: this is the first chariot with the incorrect number.
             */
            if (sideStreetChariots.isEmpty()) {
                sideStreetChariots.add(currentChariotNumber);
                position++;
                continue;
            }

            /*
             * Case: there are already chariots on the side street.
             */
            int lastParkedChariotNumber = sideStreetChariots.peek();

            /*
             * Check if we can use the last chariot instead of the current (invalid) one.
             */
            if (lastParkedChariotNumber == desiredNumber) {
                sideStreetChariots.pop();
                desiredNumber++;
                continue;
            }

            /*
             * We can neither use the current chariot nor the last one on the side street.
             * 
             * We should put the current chariot on the side street to await its turn.
             * 
             * If entering the side street would block a chariot that should exit before
             * this one, the line cannot proceed.
             */
            if (lastParkedChariotNumber < currentChariotNumber) {
                System.out.println("Cannot proceed!\n");
                return;
            }

            sideStreetChariots.add(currentChariotNumber);
            position++;
        }

        System.out.println("Can proceed!\n");
    }
}
