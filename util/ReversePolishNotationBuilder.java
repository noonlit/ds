package util;

import java.util.*;

public class ReversePolishNotationBuilder
{
    public static void main(String[] args)
    {
        Queue<Character> postfixExpression = new LinkedList<Character>();
        Stack<Character> operators = new Stack<Character>();

        char[] expression = "2+3".toCharArray();
        for (int i = 0, n = expression.length; i < n; i++) {
            Character current = expression[i];
            if (isDigit(current)) {
                postfixExpression.add(current);
                continue;
            }

            if (current == '(') {
                operators.add(current);
                continue;
            }

            if (current == ')') {
                Character aux = operators.peek();

                while (aux != '(') {
                    postfixExpression.add(aux);
                    aux = operators.pop();
                }
            }

            if (isOperator(current)) {
                if (operators.isEmpty()) {
                    operators.add(current);
                }
                
                while(hasPriority(operators.peek(), current)) {
                    postfixExpression.add(operators.pop());                  
                }
                
                continue;
            }

        }

        Stack<Character> aux = new Stack<Character>();
        while (!postfixExpression.isEmpty()) {
            Character current = postfixExpression.poll();

            if (isDigit(current)) {
                continue;
            }

            if (isOperator(current)) {

                continue;
            }

        }
    }

    private static boolean isDigit(Character input)
    {
        return input >= '0' && input <= '9';
    }

    private static boolean isOperator(Character input)
    {
        return input == '+' || input == '-' || input == '*' || input == '/';
    }
    
    private static boolean hasPriority(Character current, Character toCompare)
    {
        return true; // todo
    }
}
