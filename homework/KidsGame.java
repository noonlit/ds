package homework;

/**
 * Un grup de copii joacă un joc simplu cu un zar. Copii aruncă zarul pe rând.
 * Dacă cineva aruncă 6 atunci el/ea va arunca din nou până aruncă o valoare
 * diferită de 6.
 * 
 * Vi se dă un tablou/vector/array A cu N elemente, fiecare element fiind o
 * valoare între 0 și 6, reprezentând rezultatul unei aruncări. Pe baza
 * tabloului A, determinați numărul de copii care joacă jocul, sau afișați un
 * mesaj dacă secvența nu e validă (nu poate reprezenta rezultatul aruncărilor).
 * 
 * De exemplu, dacă A conține următoarele 7 valori [3, 6, 6, 2, 1, 2, 3], sunt 5
 * copii care joacă (primul aruncă 3, al doilea aruncă 6 de două ori urmat de un
 * 2, după care ceilalți 3 copii aruncă, pe rând, 1, 2 și 3). Dacă A conține
 * următoarele 7 valori [3, 6, 6, 2, 1, 2, 6] ea nu este validă.
 */
public class KidsGame
{
    private final static int MAX_SCORE = 6;
    
    public static void main(String[] args)
    {
        int[] scores = { 3, 6, 6, 2, 1, 2, 3 };       
        
        if (!isValidSequence(scores)) {
            System.out.println("Not a valid sequence. Try again.");
            return;
        }
        
        System.out.println("There are " + getPlayersCount(scores) + " players in the game");
    }
    
    /**
     * Checks that the given scores represent a valid sequence.
     * 
     * @param scores
     * @return
     */
    private static boolean isValidSequence(int[] scores)
    {
        int lastIndex = scores.length - 1;
        
       return scores[lastIndex] == MAX_SCORE;
    }

    /**
     * Returns the number of players in the game based on business rules :)
     * 
     * @param int[] scores
     * @return int
     */
    private static int getPlayersCount(int[] scores)
    {
        int players = 0;
        boolean hasRolledMax = false;
        
        for (int i = 0, n = scores.length; i < n; i++) {
            int currentScore = scores[i];
            
            /*
             * case: lucky player continues to be lucky - we don't count her
             */
            if (hasRolledMax && currentScore == MAX_SCORE) {
                continue;
            }
            
            /*
             * case: player just got lucky - we count her
             */
            if (!hasRolledMax && currentScore == MAX_SCORE) {
                players++;
                hasRolledMax = true;
                continue;
            }
           
            /*
             * case: player just broke her lucky streak - we don't count her
             */
            if (hasRolledMax && currentScore < MAX_SCORE) {
                hasRolledMax = false;
                continue;
            }
            
            /*
             * standard case
             */
            players++;           
        }

        return players;
    }
}
