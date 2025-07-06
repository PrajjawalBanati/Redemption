## Quick Revision of Concepts Applied

**[Problem-1-ValidParenthesis](ValidParenthesis.java)**

- Have a base condition where the starting character should not be starting with an ending parenthesis.
- Always push the opening parenthesis in the stack.
- You have to put different conditions based on different types of parenthesis. Use And operator carefully.

**[Problem-2-Min Stack](MinStackImpl.java)**

- The only trivial problem here to get the minimum element in constant time.
- Have a second stack type structure for that. Always put your minimum element in that stack.
- When deleting any element from the stack check if that element is also present in the minimum stack as well. If yes delete it.

**[Problem-3-Reverse Polish Notation](ReversePolishNotation.java)**

- Keep on pushing numbers into the stack. 
- As soon as you find the operator, pull out two operands, do the result and put it back to stack.

**[Problem-4-Generate Parenthesis](GenerateParenthesis.java)**

- This is a great back tracking problem. You need to have the intuition of finding the conditions.
- Intuition which needs to be followed is checking the opening and closing bracket counts.
  - Condition (Open > Closed and Open < Number supplied as the argument)
    - Open count should always be more than closed and not exceed the number(n).
- Do not forget to remove the character that you concatenated first.

**[Problem-5-Daily Temperatures](DailyTemperatures.java)**

- Keep an Entry of both (value , index) in the stack. Index will be needed to calculate two things:
  - At what index the result array should be calculated.
  - Also calculating the difference between the higher temperature index and the entry which you are popping.

**[Problem-6 Car Fleet](CarFleet.java)**

- Sort the cars by their starting positions from closest to the target to farthest. 
- Instead of tracking positions, compute time to reach the target.
- Simulate fleet formation using a stack of times. If a car's time is greater than the top of the stack, it forms a new fleet; else, no need to put it in the stack.
- Take care of preceding operators' logic. You need to use braces to separate subtraction and division so that subtraction is done first and then division is done second.
- Have double type cast explicitly so that it compares values in double format rather than integer.