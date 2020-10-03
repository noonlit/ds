package class_examples;

import java.util.Scanner;

/**
 * O firmă adoptă o strategie nouă de a face publicitate produsului lor. Când
 * lansează un produs nou, ei trimit publicitatea la exact 5 persoane pe
 * Facebook. În prima zi, jumătate dintre aceste persoane (în cazul numerelor
 * impare, ”jumătatea” mai mică), adică 2 persoane dau like la publicitate și
 * fiecare trimite mai departe publicitatea la exact 3 persoane (persoanele care
 * nu dau like la publicitate, o șterg fără a o trimite mai departe). Deci, la
 * începutul celei de-a 2-a zile, publicitatea a ajuns la 2 * 3 = 6 persoane
 * noi. În această zi, iarăși jumătate dintre persoane dau like și trimit mai
 * departe publicitatea la alte 3 persoane, deci la finalul celei de-a 2-a zile,
 * publicitatea ajunge la 3*3 = 9 persoane noi. 
 * 
 * Procesul se repetă în fiecare
 * zi: jumătate dintre persoanele care primesc publicitatea (dacă acest
 * număr este impar, atunci ”jumătatea” mai mică) dau like și o trimit mai
 * departe la 3 persoane. 
 * 
 * Presupunând că publicitatea nu ajunge niciodată la
 * aceeași persoană de 2 ori, calculați numărul total de persoane care dau like
 * pe parcursul a N zile. Dacă N = 2, atunci soluția este 2 (în prima zi) + 3
 * (în a 2-a zi) = 5.
 */
public class MarketingStrategy
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many days?");
        int days = scanner.nextInt();

        int recipients = 5;
        int likes = calculateLikes(recipients);

        /*
         * Start calculating on the second day, as we have the initial data for the
         * first.
         */
        for (int i = 2; i <= days; i++) {
            /*
             * The persons who liked the ad forwarded it.
             */
            int newRecipients = calculateNewRecipients(likes);

            /*
             * A subset of the new recipients liked the ad.
             */
            int newLikes = calculateLikes(newRecipients);

            likes += newLikes;
        }

        System.out.println("Total likes: " + likes);
    }

    /**
     * Calculates number of likes based on number of recipients.
     * 
     * @param int recipients
     * @return int
     */
    private static int calculateLikes(int recipients)
    {
        return Math.floorDiv(recipients, 2);
    }

    /**
     * Calculates how many people will receive an ad based on the number of people
     * who are easily impressed by such ads.
     * 
     * @param int spammers
     * @return int
     */
    private static int calculateNewRecipients(int spammers)
    {
        return spammers * 3;
    }

}
