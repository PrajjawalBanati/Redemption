import java.util.Stack;

/*
* You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
* The input string s is valid if and only if:
* Every open bracket is closed by the same type of close bracket.
* Open brackets are closed in the correct order.
* Every close bracket has a corresponding open bracket of the same type.
* Return true if s is a valid string, and false otherwise.
*
* Example 1:
*
* Input: s = "[]"
* Output: true
*
* Example 2:
*
* Input: s = "([{}])"
* Output: true
*
* Example 3:
*
* Input: s = "[(])"
* Output: false
* Explanation: The brackets are not closed in the correct order.
*
* Constraints:
* 1 <= s.length <= 1000
* */
public class ValidParenthesis {
    public boolean isValidParenthesis(String s) {
        int parentLength = s.length();
        Stack<Character> parenthesisStack = new Stack<>();
        if(s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']')
        {
            return false;
        }
        for(int i = 0; i < parentLength; i++)
        {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
            {
                parenthesisStack.push(ch);
            }
            else if(ch == ')' || ch == '}' || ch == ']')
            {
                if(!parenthesisStack.isEmpty() && parenthesisStack.peek() == '(' && ch ==')')
                {
                    parenthesisStack.pop();
                }
                else if(!parenthesisStack.isEmpty() && parenthesisStack.peek() == '[' && ch ==']')
                {
                    parenthesisStack.pop();
                }
                else if(!parenthesisStack.isEmpty() && parenthesisStack.peek() == '{' && ch == '}')
                {
                    parenthesisStack.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        return parenthesisStack.isEmpty();
    }
}
