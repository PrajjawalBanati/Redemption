public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        // find the pivot index
        // Compare target and nums[0]
        // if target is less than nums[0] do binary search on the right section
        // if target is more than nums[0] do binary search on the left section
        int left = 0, right = nums.length-1;
        int rotatedIndex=0;
        if(nums[left] <= nums[right])
        {
            while(left <= right)
            {
                int mid = left + (right - left)/2;
                if(nums[mid] == target)
                {
                    return mid;
                }
                else if(nums[mid] > target)
                {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
        }
        else {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < nums[0]) {
                    rotatedIndex = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (target >= nums[0]) {
                left = 0;
                right = rotatedIndex - 1;
            } else {
                left = rotatedIndex;
                right = nums.length - 1;
            }
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
