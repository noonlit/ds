package class_examples;

import java.util.Scanner;

/**
 * Un profesor de matematică predă într-o clasă cu N studenți. El este foarte
 * supărat pentru că o mare parte dintre studenți vin cu întârziere la ore, și
 * decide că dacă mai puțin de K studenți sunt în sală la începutul orei, el nu
 * va mai ține ora. Citind de la tastatură numerele N și K, urmate de N numere,
 * reprezentând timpul de sosire pentru fiecare student, să se afișeze dacă
 * profesorul de matematică va ține ora sau nu. Timpul de sosire este un număr
 * negativ pentru studenții care au venit mai repede, 0 pentru cei care ajung
 * exact la începutul orei și pozitiv pentru cei care întârzie.
 */
public class AngryProf
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many students are in the class?");
        int n = scanner.nextInt();

        System.out.println("How many students must be present?");
        int k = scanner.nextInt();

        int studentsOnTime = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("When did student " + i + " arrive?");
            int arrivalTime = scanner.nextInt();

            if (arrivalTime <= 0) {
                studentsOnTime++;
            }
        }

        scanner.close();

        if (studentsOnTime >= k) {
            System.out.println("The prof will hold the class!");
            return;
        }

        System.out.println("The prof will not hold the class!");
    }
}
