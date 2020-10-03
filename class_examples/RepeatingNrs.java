package class_examples;
import java.util.HashMap;
import java.util.Map;

/**
 * Charlie îi trimite pe îngerii lui să citească și să memoreze un mesaj secret
 * alcătuit din numere unice. Fiecare înger citește mesajul respectiv și
 * încearcă să-l memoreze, după care se întoarce la Charlie și ii spune mesajul.
 * Numai că cele 3 mesaje memorate de îngeri nu sunt identice... Charlie decide
 * că el va considera ca parte din mesaj doar acele numere care apar în mesajele
 * spuse de cel puțin 2 din cei 3 îngeri. Având 3 vectori cu numerele spuse de
 * îngeri, decideți care vor fi numerele considerate de Charlie ca făcând parte
 * din mesajul secret. 
 * 
 * De exemplu, dacă îngerii se întorc cu mesajele 
 * [57, 23, 90, 42, 30], [92, 21, 57, 90, 35, 23] și [57, 90, 23, 21, 30] 
 * Charlie va considera că mesajul secret este alcătuit din numerele [57, 21, 90, 30, 23].
 */
public class RepeatingNrs
{

    public static void main(String[] args)
    {
        int[] numbers1 = { 57, 23, 90, 42, 30 };
        int[] numbers2 = { 92, 21, 57, 90, 35, 23 };
        int[] numbers3 = { 57, 90, 23, 21, 30 };
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        addToMap(numbers1, map);
        addToMap(numbers2, map);
        addToMap(numbers3, map);
       
        /*
         * In resulting HashMap, which contains [message => occurrences] pairs, 
         * we are only interested in messages that occur at least twice
         */
        for (Map.Entry<Integer, Integer> value : map.entrySet()) {
            if (value.getValue() >= 2) {
                System.out.println(value.getKey() + " is part of the secret message.");
            }
        } 
    }
    
    /**
     * Adds vector to map, using the integers in the vector as a key 
     * and the number of occurrences for that integer as a value.
     * 
     * @param int[] numbers
     * @param Map<Integer><Integer> map
     * @return 
     * @return
     */
    private static Map<Integer, Integer> addToMap(int[] numbers, Map<Integer, Integer> map)
    {
        for (Integer i : numbers) { 
            Integer j = map.get(i); 
            map.put(i, (j == null) ? 1 : j + 1); 
        } 
        
        return map;
    }
}
