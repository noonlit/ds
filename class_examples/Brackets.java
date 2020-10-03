package class_examples;
import java.util.*;

/**
 * Să considerăm o secvență de paranteze (paranteze rotunde, pătrate și
 * acolade). Trebuie să verificăm dacă secvența este corectă. 
 * 
 * De exemplu:
 * ([])((){}[]) – este corectă 
 * (((()) – nu este corectă (prima paranteză nu este închisă deloc) 
 * ([)] – nu este corectă (ordinea în care sunt închise parantezele nu e ok) 
 * ([{}])}{ – nu este corectă (avem o acoladă închisă care nu a fost deschisă nicăieri).
 */
public class Brackets
{
    public static void main(String[] args)
    {
        String input = "[(]";

        Stack<Character> brackets = new Stack<Character>();

        for (int i = 0, n = input.length(); i < n; i++) { 
            Character currentBracket = input.charAt(i);
            if (isOpenBracket(currentBracket)) {
                brackets.push(currentBracket);
                continue;
            }
            
            /*
             * If the stack is empty right now, 
             * there is a mismatch between the number of open and closed brackets.
             */
            if (brackets.isEmpty()) {
                System.out.println("Sequence is invalid.");
                return;
            }

            /*
             * Compare the last open bracket to the current bracket, which can only be closed.
             */
            Character lastBracket = brackets.pop();
            if (!areMatchingBrackets(lastBracket, currentBracket)) {
                System.out.println("Brackets do not match. Sequence is invalid.");
                return;
            }
        }

        /*
         * If we removed all brackets from the stack, the sequence is valid
         * (all brackets are paired)
         */
        if (brackets.empty()) {
            System.out.println("All brackets match!");
            return;
        }

        /*
         * Some brackets are still present (and therefore unpaired),
         * the sequence is invalid.
         */
        System.out.println("Brackets do not match. Sequence is invalid.");
    }

    /**
     * Checks that the given bracket is an open bracket.
     * 
     * @param Character bracket
     * @return boolean
     */
    private static boolean isOpenBracket(Character bracket)
    {
        return bracket == '(' || bracket == '[' || bracket == '{';
    }

    /**
     * Checks that the given brackets match.
     * 
     * @param Character openBracket
     * @param Character closedBracket
     * @return boolean
     */
    private static boolean areMatchingBrackets(Character openBracket, Character closedBracket)
    {
        if (openBracket == '(' && closedBracket == ')') {
            return true;
        }

        if (openBracket == '[' && closedBracket == ']') {
            return true;
        }

        if (openBracket == '{' && closedBracket == '}') {
            return true;
        }

        return false;
    }
}
