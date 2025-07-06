/*
 * You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of parentheses.
 *
 * Example 1:
 *
 * Input: n = 1
 *
 * Output: ["()"]
 * Example 2:
 *
 * Input: n = 3
 *
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * You may return the answer in any order.
 *
 * Constraints:
 *
 * 1 <= n <= 7
 */

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void addParenthesis(StringBuilder str, int open, int closed, int n, List<String> parenthesisList)
    {
        if(open == n && closed == n)
        {
            parenthesisList.add(str.toString());
        }
        else if(open >= closed && open < n)
        {
            addParenthesis(str.append('('),open+1, closed, n, parenthesisList);
            str.deleteCharAt(str.length()-1);
            addParenthesis(str.append(')'),open, closed+1,n, parenthesisList);
            str.deleteCharAt(str.length()-1);
        }
        else if(open > closed && open == n)
        {
            addParenthesis(str.append(')'),open,closed+1,n,parenthesisList);
            str.deleteCharAt(str.length()-1);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> parenthesisStrings = new ArrayList<>();
        int open = 0, closed = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        open++;
        addParenthesis(stringBuilder,open,closed,n,parenthesisStrings);
        return parenthesisStrings;
    }
}
