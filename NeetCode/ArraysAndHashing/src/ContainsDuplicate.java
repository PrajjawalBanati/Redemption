import java.util.HashSet;

/*
* Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
*
* Example 1:
* Input: nums = [1, 2, 3, 3]
* Output: true
*
* Example 2:
* Input: nums = [1, 2, 3, 4]
* Output: false
*
* */
public class ContainsDuplicate {
    public boolean containsDup(int[] nums)
    {
        HashSet<Integer> hs = new HashSet<>();
        boolean isFound = false;
        for(int i = 0; i < nums.length; i++) {
            if(hs.contains(nums[i]))
            {
                isFound = true;
                break;
            }
            else{
                hs.add(nums[i]);
            }
        }
        return isFound;
    }
}
