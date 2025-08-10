public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i: nums)
        {
            int index = Math.abs(i) - 1;
            if(nums[index] < 0)
            {
                return Math.abs(i);
            }
            else {
                nums[index] *= -1;
            }
        }
        return -1;
    }
}
