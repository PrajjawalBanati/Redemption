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
