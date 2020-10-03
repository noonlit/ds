package class_examples;

/**
 * Biblioteca locală are nevoie de ajutorul nostru! Se dau data în care o carte
 * trebuia returnată și data în care a fost returnată. Să se calculeze cât este
 * amenda (dacă este cazul). Amenda se calculează după următoarele reguli:
 * 
 * Dacă cartea este returnată în ziua în care trebuie returnată sau mai devreme,
 * amenda este 0 RON.
 * 
 * Dacă cartea este returnată după ziua în care trebuie returnată, 
 * dar în aceeași lună, amenda este 5 RON * numărul de zile de
 * întârziere.
 * 
 * Dacă cartea este returnată după luna în care trebuia returnată,
 * dar în același an, amenda este 50 RON * numărul de luni de întârziere. 
 * 
 * Dacă cartea este returnată în alt an, decât anul în care trebuia returnată există
 * o amendă fixă de 1000 RON.
 */
public class LibraryFine
{
    public static void main(String[] args)
    {
        int dDay = 7;
        int dMonth = 12;
        int dYear = 2019;

        int currentDay = 7;
        int currentMonth = 12;
        int currentYear = 2019;

        if (currentDay <= dDay && currentMonth <= dMonth && currentYear <= dYear) {
            System.out.println(0);
            return;
        }

        if (currentYear > dYear) {
            System.out.println(1000);
            return;
        }

        if (currentYear == dYear && currentMonth == dMonth && currentDay > dDay) {
            int fine = 5 * (currentDay - dDay);
            System.out.println(fine);
            return;
        }

        if (currentYear == dYear && currentMonth > dMonth) {
            int fine = 50 * (currentMonth - dMonth);
            System.out.println(fine);
        }

    }
}
