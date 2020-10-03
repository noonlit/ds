package homework;

import java.util.Scanner;

/**
 * Două pisici, numite A și B, stau pe punctele întregi ale axei OX. Pisica A
 * stă pe punctul x și pisica B stă pe punctul y. Ambele pisici aleargă cu
 * aceeași viteză și vor să prindă șoarecele C care este pe punctul z. Având mai
 * multe interogări sub forma (x, y, z) determinați și afișați pentru fiecare
 * interogare, care pisică ajunge prima dată la șoarece (A sau B). Dacă cele 2
 * pisici ajung în același timp la șoarece, afișați C (cele 2 pisici se ceartă
 * și șoarecele scapă).
 * 
 * De ex. dacă avem pozițiile (10, 20, 18), rezultatul este B (A este pe poziția
 * 10, B e pe poziția 20, șoarecele pe poziția 18) și dacă avem (10, 12, 2),
 * rezultatul este A.
 * 
 * Va trebui să scrieți 2 funcții:
 * 
 * una care pentru un triplet de poziții x, y, z (poziția pisicii A, poziția
 * pisicii B, poziția pentru șoarece) determină și returnează cine ajunge prima
 * dată la șoarece (A, B sau C).
 * 
 * A 2-a funcție citește pe rând interogările (până se introduc 3 valori egale),
 * și după fiecare interogare citită apelează prima funcție, și afișează
 * rezultatul funcției. Interogările nu vor fi reținute în listă/tablou/vector
 * (tot timpul lucrăm cu interogarea curentă numai).
 */
public class CatsAndMouse
{
    public static void main(String[] args)
    {
        playCatsAndMouse();
    }
    
    private static void playCatsAndMouse()
    {
        Scanner scan = new Scanner(System.in);
        int x = 0;
        int y = 0;
        int z = 1;
        
        while (!(x == y && y == z)) {
            System.out.println("Where is cat A?");
            x = scan.nextInt();
            
            System.out.println("Where is cat B?");
            y = scan.nextInt();
            
            System.out.println("Where is the mouse?");
            z = scan.nextInt();
            
            Character result = getRaceResult(x, y, z);
            System.out.println("The result is: " + result);
        }
        
        System.out.println("Bye!");
        scan.close();
    }
    
    private static Character getRaceResult(int catAPosition, int catBPosition, int mousePosition)
    {
        int distanceFromAToMouse = Math.abs(catAPosition - mousePosition);
        int distanceFromBToMouse = Math.abs(catBPosition - mousePosition);
        
        if (distanceFromAToMouse == distanceFromBToMouse) {
            return 'C';
        }
        
        return distanceFromAToMouse < distanceFromBToMouse ? 'A' : 'B';      
    }
}
