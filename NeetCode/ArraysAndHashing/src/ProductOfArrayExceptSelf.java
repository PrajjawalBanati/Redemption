/*
* Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].
* Each product is guaranteed to fit in a 32-bit integer.
* Follow-up: Could you solve it in O(n)
* O(n) time without using the division operation?
* Example 1:
* Input: nums = [1,2,4,6]
* Output: [48,24,12,8]
*
* Example 2:
* Input: nums = [-1,0,1,2,3]
* Output: [0,-6,0,0,0]
*
* Constraints:
*
* 2 <= nums.length <= 1000
* -20 <= nums[i] <= 20
*
* */

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums)
    {
        int size = nums.length;
        int[] prefixProduct = new int[size];
        int[] suffixProduct = new int[size];
        prefixProduct[0] = nums[0];
        suffixProduct[size-1] = nums[size-1];
        for(int i = 1; i < size; i++)
        {
            prefixProduct[i] = prefixProduct[i-1]*nums[i];
            suffixProduct[size - i - 1] = suffixProduct[size-i]*nums[size-i-1];
        }
        int[] answer = new int[size];
        for(int i = 0; i < size; i++)
        {
            if(0 == i)
            {
                answer[i] = suffixProduct[i+1];
            }
            else if(size -1 == i)
            {
                answer[i] = prefixProduct[i-1];
            }
            else
            {
                answer[i] = prefixProduct[i-1] * suffixProduct[i+1];
            }
        }
        return answer;

    }
}
