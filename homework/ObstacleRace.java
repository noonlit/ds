package homework;

import java.util.Scanner;

/**
 * Dan participă într-o competiție de alergare cu obstacole (garduri), unde el
 * va trebui să sară peste n obstacole care au înălțimile h0, h1, h2,…,hn-1. La
 * începutul cursei el poate să sară la o înălțime de k unități. Dan are un stoc
 * nelimitat de poțiune magică, care poate să-l ajute să sară mai sus. Fiecare
 * porție de poțiune băută crește înălțimea la care poate să sară cu 1. Însă,
 * după fiecare săritură el devine mai obosit, și înălțimea la care poate să
 * sară scade cu 1 (indiferent de faptul că a băut poțiune sau nu). Calculați
 * numărul minim de poțiuni de care are nevoie Dan, pentru a termina cursa.
 * 
 * De ex. dacă sunt 5 obstacole de înălțime [1, 6, 3, 5, 2] și înălțimea
 * inițială este 4, Dan are nevoie de minim 4 poțiuni (peste obstacolul 1 sare
 * fără probleme, dar înălțimea scade la 3, pentru a sări peste 6 are nevoie de
 * 3 poțiuni. După săritura peste obstacolul cu 6 va avea înălțime 5, deci sare
 * peste obstacolul cu 3 fără probleme, dar înălțimea scade la 4. Pentru a sări
 * peste obstacolul cu 5 are nevoie de o poțiune, după săritură având înălțime
 * 4, deci poate să sară peste obstacolul 2).
 * 
 * Pentru rezolvarea problemei va trebui să scrieți 2 funcții:
 * 
 * una, care primește ca parametru numărul de obstacole, un tablou/o listă cu
 * înălțimile obstacolelor și valoarea k (înălțimea inițială). Funcția
 * calculează și returnează numărul minim de poțiuni necesare.
 * 
 * A 2-a funcție citește numărul de obstacole, citește înălțimea obstacolelor și
 * valoarea k. După citirea datelor funcția apelează prima funcție și afișează
 * rezultatul ei.
 */
public class ObstacleRace
{
    public static void main(String[] args)
    {
        runRace();
    }

    private static void runRace()
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("How many obstacles?");
        int obstacleCount = scan.nextInt();
        int[] obstacleHeights = new int[obstacleCount];
        
        for (int i = 0; i < obstacleCount; i++) { 
            System.out.println(String.format("Insert the height of obstacle #%d", i+1));;
            obstacleHeights[i] = scan.nextInt();
        }
        
        System.out.println("How high can Dan jump in the beginning?");
        int initialCapacity = scan.nextInt();

        scan.close();
        
        System.out.println(String.format("Dan will need %d potions to finish the race.", getPotionsCount(obstacleCount, obstacleHeights, initialCapacity)));
    }

    private static int getPotionsCount(int obstacleCount, int[] obstacleHeights, int initialCapacity)
    {
        int potionsCount = 0;
        int capacity = initialCapacity;
        
        for (int i = 0, n = obstacleHeights.length; i < n; i++) {
            int potionsNeeded = obstacleHeights[i] - capacity;
            
            if (potionsNeeded > 0) {
                potionsCount += potionsNeeded;
                capacity += potionsNeeded;
            }
            
            capacity--;
        }
        
        return potionsCount;
    }
}
