import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/*
 * There are n cars traveling to the same destination on a one-lane highway.
 *
 * You are given two arrays of integers position and speed, both of length n.
 *
 * position[i] is the position of the ith car (in miles)
 * speed[i] is the speed of the ith car (in miles per hour)
 * The destination is at position target miles.
 *
 * A car can not pass another car ahead of it. It can only catch up to another car and then drive at the same speed as the car ahead of it.
 *
 * A car fleet is a non-empty set of cars driving at the same position and same speed. A single car is also considered a car fleet.
 *
 * If a car catches up to a car fleet the moment the fleet reaches the destination, then the car is considered to be part of the fleet.
 *
 * Return the number of different car fleets that will arrive at the destination.
 *
 * Example 1:
 *
 * Input: target = 10, position = [1,4], speed = [3,2]
 *
 * Output: 1
 * Explanation: The cars starting at 1 (speed 3) and 4 (speed 2) become a fleet, meeting each other at 10, the destination.
 *
 * Example 2:
 *
 * Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]
 *
 * Output: 3
 * Explanation: The cars starting at 4 and 7 become a fleet at position 10. The cars starting at 1 and 0 never catch up to the car ahead of them. Thus, there are 3 car fleets that will arrive at the destination.
 *
 * Constraints:
 *
 * n == position.length == speed.length.
 * 1 <= n <= 1000
 * 0 < target <= 1000
 * 0 < speed[i] <= 100
 * 0 <= position[i] < target
 * All the values of position are unique.
 */
public class CarFleet {
    static class Pair{
        int position;
        int speed;
        Pair(int position, int speed)
        {
            this.position = position;
            this.speed = speed;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> positionSpeed = new ArrayList<>();
        for(int i = 0; i < position.length; i++)
        {
            Pair sPos = new Pair(position[i], speed[i]);
            positionSpeed.add(sPos);
        }
        positionSpeed.sort((a,b)->a.position - b.position);
        Stack<Pair> speedStack = new Stack<>();
        for(int i = position.length-1; i >=0; i--)
        {
            if(speedStack.isEmpty())
            {
                speedStack.push(positionSpeed.get(i));
            }
            else{
                while(!speedStack.isEmpty() && ((double)(target-speedStack.peek().position)/(speedStack.peek().speed)) <
                        ((double)(target-positionSpeed.get(i).position)/(positionSpeed.get(i).speed)))
                {
                    speedStack.push(positionSpeed.get(i));
                }
            }
        }
        return speedStack.size();
    }
}
