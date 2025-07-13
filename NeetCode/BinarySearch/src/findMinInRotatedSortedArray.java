/**
 * You are given an array of length n which was originally sorted in ascending order.<br/>
 * It has now been rotated between 1 and n times. For example, the array nums = [1,2,3,4,5,6] might become:<br/><br/>
 *
 * [3,4,5,6,1,2] if it was rotated 4 times.<br/>
 * [1,2,3,4,5,6] if it was rotated 6 times.<br/><br/>
 * Notice that rotating the array 4 times moves the last four elements of the array to the beginning. Rotating the array 6 times produces the original array.<br/><br/>
 *
 * Assuming all elements in the rotated sorted array nums are unique, return the minimum element of this array.<br/><br/>
 *
 * A solution that runs in O(n) time is trivial, can you write an algorithm that runs in O(log n) time?<br/><br/>
 *
 * Example 1:<br/><br/>
 *
 * Input: nums = [3,4,5,6,1,2]<br/><br/>
 *
 * Output: 1<br/>
 * Example 2:<br/><br/>
 *
 * Input: nums = [4,5,0,1,2,3]<br/><br/>
 *
 * Output: 0<br/>
 * Example 3:<br/><br/>
 *
 * Input: nums = [4,5,6,7]<br/><br/>
 *
 * Output: 4<br/>
 * Constraints:<br/><br/>
 *
 * 1 <= nums.length <= 1000<br/>
 * -1000 <= nums[i] <= 1000<br/>
 */
public class findMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int rotatedIndex=0;
        int left = 0, right = nums.length-1;
        if(nums[left] < nums[right])
        {
            return nums[left];
        }
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[0])
            {
                rotatedIndex = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return nums[rotatedIndex];
    }
}
