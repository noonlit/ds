package class_examples;

import java.util.PriorityQueue;

import util.CandyBag;

/**
 * Dianei îi plac dulciurile foarte mult. Plimbându-se prin parc, ea găsește N
 * pungi, fiecare având un anumit număr de bomboane. Ea ridică o pungă, mănâncă
 * toate bomboanele din ea și aruncă punga pe jos. În mod magic, în pungă apar
 * niște bomboane noi: dacă punga inițial conținea X bomboane, după ce Diana le
 * mănâncă și arungă punga, în pungă o să apară X/2 bomboane.
 * 
 * Diana e impresionată de această magie, și vrea să mănânce cât mai multe
 * bomboane, dar in K minute ea trebuie să se întoarcă acasă. Într-un minut ea
 * poate să mănânce conținutul unei pungi (indiferent de numărul de bomboane din
 * ea). Având numărul bomboanelor pentru fiecare pungă și valoarea K,
 * determinați numărul maxim de bomboane pe care Diana le poate mânca.
 * 
 * De exemplu, dacă inițial sunt 5 pungi cu câte [2, 1, 7, 4, 2] bomboane iar
 * Diana are 3 secunde la dispoziție, ea poate mânca 7 + 4 + 3 bomboane.
 */
public class MultiplyingCandy
{
    public static void main(String[] args)
    {
        int[] candyBags = { 2, 1, 7, 4, 2 };
        int minutes = 3;
        
        PriorityQueue<CandyBag> queue = new PriorityQueue<CandyBag>();
        
        /*
         * Every minute, Diana wants to eat the contents of the biggest bag.
         */
        for (int i = 0; i < minutes; i++) {
            int maxCandyAmount = candyBags[0];
            int maxCandyIndex  = 0;
            
            for (int j = 1, n = candyBags.length; j < n; j++) {
                if (candyBags[j] > maxCandyAmount) {
                    maxCandyAmount = candyBags[j];
                    maxCandyIndex  = j;
                }
            }
            
            CandyBag bag = new CandyBag(maxCandyAmount);
            queue.add(bag);
            
            /*
             * Once the contents have been eaten, half the pieces get replaced.
             */
            candyBags[maxCandyIndex] = maxCandyAmount / 2;
        }
        
        int totalCandies = 0;
        for (int i = 0; i < minutes; i++) {
            int candies = queue.poll().getCandies();
            System.out.println("Current bag contains this many pieces: " + candies);
            totalCandies += candies;
        }
        
        System.out.println("Total: " + totalCandies);
    }
}
