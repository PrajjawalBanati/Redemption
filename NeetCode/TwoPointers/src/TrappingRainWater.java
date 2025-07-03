/*
* You are given an array of non-negative integers height which represent an elevation map.
* Each value height[i] represents the height of a bar, which has a width of 1.
* Return the maximum area of water that can be trapped between the bars.
*
* Example 1:
* Input: height = [0,2,0,3,1,0,1,3,2,1]
* Output: 9
*
* */
public class TrappingRainWater {
    public int trapWater(int[] height)
    {
        int WLength = height.length;
        int left = 0, right = WLength - 1;
        int maxLeft = 0, maxRight = 0;
        int totalArea = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                totalArea += maxLeft - height[left];
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                totalArea += maxRight - height[right];
                right--;
            }
        }

        return totalArea;
    }
}
