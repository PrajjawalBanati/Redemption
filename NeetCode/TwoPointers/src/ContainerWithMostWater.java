/*
* You are given an integer array heights where heights[i] represents the height of the ith bar.
* You may choose any two bars to form a container. Return the maximum amount of water a container can store.
*
* Example 1:
* Input: height = [1,7,2,5,4,7,3,6]
* Output: 36
*
* Input: height = [2,2,2]
* Output: 4
*/
public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int Wlength = heights.length;
        int start = 0;
        int end = Wlength-1;
        int maxArea = 0;
        while(start < end)
        {
            int area = Math.min(heights[start], heights[end]) * (end - start + 1);
            maxArea = Math.max(maxArea, area);
            if(heights[start] <= heights[end])
            {
                start++;
            }
            else{
                end--;
            }
        }
        return maxArea;
    }
}
