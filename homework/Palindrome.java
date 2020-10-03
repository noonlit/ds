package homework;

/**
 * Un string este palindrom dacă este la fel indiferent dacă-l citim din
 * stânga spre dreapta sau din dreapta spre stânga. De exemplu cuvântul capac
 * este palindrom. Pentru un string dat, determinați dacă este palindrom sau nu.
 * Dacă e palindom, afișați și dacă e palindrom de lungime pară (de exemplu
 * abccba) sau de lungime impară (de exemplu abcba).
 */
public class Palindrome
{

    public static void main(String[] args)
    {
        /*
         * TODO: read from stdin, maybe
         */
        // String string = "Able was I ere I saw Elba";
        String string = "A man, a plan, a canal – Panama";
        // String string = "Never odd or even";
        // String string = "Not a palindrome";

        /*
         * Palindrome: char pairs on either side of the midpoint are the same.
         * 
         * Case, punctuation and whitespace should be ignored.
         */
        string = string.replaceAll("[\\p{P}\\s]", "").toLowerCase();
        System.out.println(string);

        int length = string.length();
        int midpoint = Math.floorDiv(length, 2);

        /*
         * If the string is of even length, the calculated midpoint is off by 1.
         */
        boolean isEven = length % 2 == 0;
        if (isEven) {
            midpoint -= 1;
        }

        boolean isPalindrome = true;
        int lastElementIndex = length - 1;

        for (int i = 0; i < midpoint; i++) {
            if (string.charAt(i) != string.charAt(lastElementIndex)) {
                isPalindrome = false;
                break;
            }

            lastElementIndex--;
        }

        /*
         * Display result.
         */
        String lengthType = isEven ? "even" : "odd";
        System.out.println("The string is of " + lengthType + " length");
        String stringType = isPalindrome ? "a palindrome" : "not a palindrome";
        System.out.println("The string is " + stringType);
    }
}
