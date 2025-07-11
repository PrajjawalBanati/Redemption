/*
 * You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.
 *
 * Return the integer that represents the evaluation of the expression.
 *
 * The operands may be integers or the results of other operations.
 * The operators include '+', '-', '*', and '/'.
 * Assume that division between integers always truncates toward zero.
 * Example 1:
 *
 * Input: tokens = ["1","2","+","3","*","4","-"]
 *
 * Output: 5
 *
 * Explanation: ((1 + 2) * 3) - 4 = 5
 * Constraints:
 *
 * 1 <= tokens.length <= 1000.
 * tokens[i] is "+", "-", "*", or "/", or a string representing an integer in the range [-100, 100].
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> expressionStack = new Stack<>();
        Map<String, BiFunction<Integer, Integer, Integer>> functionMap = new HashMap<>();
        functionMap.put("+",(a,b)-> a+b);
        functionMap.put("-",(a,b)-> a-b);
        functionMap.put("*",(a,b)-> a*b);
        functionMap.put("/",(a,b)-> a/b);

        for(String s: tokens)
        {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            {
                int secondElement = Integer.parseInt(expressionStack.pop());
                int firstElement = Integer.parseInt(expressionStack.pop());
                expressionStack.add(Integer.toString(functionMap.get(s).apply(firstElement,secondElement)));
            }
            else {
                expressionStack.push(s);
            }
        }
        return Integer.parseInt(expressionStack.pop());
    }
}
