package homework;

import java.util.Scanner;

/**
 * Oana se plimbă prin pădure și găsește un arbore magic. Pe fiecare frunză a
 * acestui arbore este un string care reprezintă o expresie aritmetică, formată
 * din cifre (0-9) și operatorii + și – (nu există paranteze, nu există
 * înmulțire sau împărțire).
 * 
 * Oana vrea să ia acasă frunza pe care este scrisă expresia care are cea mai
 * mare valoare. Ajutați-o pe Oana să găsească această frunză.
 * 
 * Dacă sunt mai multe frunze care au expresie de valoare maximă, Oana alege
 * ultima expresie găsită. De exemplu: dacă o frunză conține expresia
 * 4+2-5+3+2-4 valoarea frunzei este 2, dacă frunza conține expresia 1+1+1+1
 * valoarea frunzei este 4. Dacă după frunza cu 1+1+1+1 Oana găsește frunza
 * 2+7+1-6 (tot de valoare 4) ea va alege frunza 2+7+1-6.
 * 
 * Va trebui să implementați 2 funcții:
 * 
 * Prima funcție primește ca parametru o expresie (sub forma unui string) și
 * returnează valoarea expresiei.
 * 
 * A 2-a funcție citește pe rând expresiile (până se introduce un String vid),
 * calculează valoarea lor și la final returnează expresia de pe frunza luată
 * acasă de Oana. Pentru parcurgerea expresiei puteti folosi funcția charAt(i)
 * din Java care vă dă caracterul de pe o poziție dintr-un string, iar pentru
 * transformarea unui caracter in cifra corespunzătoare puteți folosi (int cifra
 * = caracter – ‘0’).
 */

public class MaxExpression
{

    public static void main(String[] args)
    {
        System.out.println(String.format("The leaf Oana took home has the expression: %s.", getMaxString()));
    }

    /**
     * Evaluates a string expression and returns the result.
     * 
     * @param String expression
     * @return int
     */
    private static int evaluateExpression(String expression)
    {
        int stringLength = expression.length();

        int result = 0;
        boolean nextIsNegative = false;
        for (int i = 0; i < stringLength; i++) {
            Character current = expression.charAt(i);

            if (!Character.isDigit(current)) {
                nextIsNegative = current == '-';
                continue;
            }

            if (nextIsNegative) {
                result -= current - '0';
                continue;
            }

            result += current - '0';
            continue;
        }

        return result;
    }

    /**
     * Returns the string that evaluates to the highest number.
     * 
     * @return String
     */
    private static String getMaxString()
    {
        Scanner scan = new Scanner(System.in);

        String input = "No expression.";
        String maxExpression = "";
        int maxExpressionValue = 0;

        while (!input.isEmpty()) {
            System.out.println("Enter an expression:");
            input = scan.nextLine();

            int evaluatedExpression = evaluateExpression(input);
            System.out.println("input = " + evaluatedExpression);

            if (evaluatedExpression >= maxExpressionValue) {
                maxExpressionValue = evaluatedExpression;
                maxExpression = input;
            }
        }

        scan.close();

        return maxExpression;
    }

}
