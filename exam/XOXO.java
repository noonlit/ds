package exam;

import java.util.Scanner;

public class XOXO
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        /*
         * Expression represents quiz answers.
         * 
         * Correct answers: O
         * Wrong answers: X
         * Score for wrong answers: 0
         * Score for correct answers: 1 + previous consecutive right answers.
         */
        System.out.println("Enter an expression (e.g. OOXXOXXOOO):");
        String input = scan.nextLine();
        while (!input.isEmpty()) {
            System.out.println("Result = " + getScore(input));
            System.out.println("Enter an expression (e.g. OOXXOXXOOO):");
            input = scan.nextLine();
        }

        scan.close();  
        System.out.println("We have reached the end.");
    }
    
    private static int getScore(String scores)
    {
        int score = 0;
        int correctConsecutiveAnswers = 0;
        
        /*
         * Iterate string character by character.
         */
        for (int i = 0; i < scores.length(); i++) {
            Character currentCharacter = scores.charAt(i);
            
            /*
             * X means 0 points, we can continue.
             */
            if (currentCharacter == 'X') {
                correctConsecutiveAnswers = 0;
                continue;
            }
                      
            /*
             * 0 means 1 point + previous consecutive correct answers. 
             */
            int toAdd = 1 + correctConsecutiveAnswers;
            
            score += toAdd;
            correctConsecutiveAnswers++;
        }
        
        return score;
    }
}
