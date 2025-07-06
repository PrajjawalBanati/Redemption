import java.util.*;

/*
 * You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.
 *
 * Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a future day. If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0 instead.
 *
 * Example 1:
 *
 * Input: temperatures = [30,38,30,36,35,40,28]
 *
 * Output: [1,4,1,2,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [22,21,20]
 *
 * Output: [0,0,0]
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Map.Entry<Integer, Integer>> entryStack = new Stack<>();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            while(!entryStack.isEmpty() &&  temperatures[i] > entryStack.peek().getKey())
            {
                Map.Entry<Integer,Integer> mp = entryStack.pop();
                arr[mp.getValue()] = (i - mp.getValue());
            }
            entryStack.push(Map.entry(temperatures[i], i));
        }
        return arr;
    }
}
