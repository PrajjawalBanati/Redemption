/*
* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
* Implement the MinStack class:
* MinStack() initializes the stack object.
* void push(int val) pushes the element val onto the stack.
* void pop() removes the element on the top of the stack.
* int top() gets the top element of the stack.
* int getMin() retrieves the minimum element in the stack.
*
* You must implement a solution with O(1) time complexity for each function.
* Example 1:
* Input
* ["MinStack","push","push","push","getMin","pop","top","getMin"]
* [[],[-2],[0],[-3],[],[],[],[]]
* Output
* [null,null,null,null,-3,null,0,-2]
*
* Explanation
*
* MinStack minStack = new MinStack();
* minStack.push(-2);
* minStack.push(0);
* minStack.push(-3);
* minStack.getMin(); // return -3
* minStack.pop();
* minStack.top();    // return 0
* minStack.getMin(); // return -2
*
* Constraints:
* -231 <= val <= 231 - 1
* Methods pop, top and getMin operations will always be called on non-empty stacks.
* At most 3 * 104 calls will be made to push, pop, top, and getMin.
* */
import java.util.*;
public class MinStackImpl {
    List<Integer> minStack;
    int top;
    int minTop;
    List<Integer> minimumElementArr;
    public MinStackImpl(){
        minStack = new ArrayList<>();
        minimumElementArr = new ArrayList<>();
        top = -1;
        minTop = -1;
    }
    public void push(int val){
        ++top;
        minStack.add(val);
        if(minTop == -1 || val <= minimumElementArr.get(minTop))
        {
            minTop++;
            minimumElementArr.add(val);
        }
    }
    public void pop() {
        if(top == -1){return;}
        else {
            int elementToRemove = minStack.get(top);
            if(elementToRemove == minimumElementArr.get(minTop))
            {
                minimumElementArr.remove(minTop);
                minTop--;
            }
            minStack.remove(top);
            top--;
        }
    }

    public int top() {
        return minStack.get(top);
    }

    public int getMin() {
        return minimumElementArr.get(minTop);
    }
}
