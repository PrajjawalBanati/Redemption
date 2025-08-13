import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> returnSubsets = new ArrayList<>();
        List<Integer> subsetEntry = new ArrayList<>();
        int curr_index = 0;
        create_subsets(nums, subsetEntry, returnSubsets, curr_index);
        return returnSubsets;
    }

    private void create_subsets(int[] nums, List<Integer> subsetEntry, List<List<Integer>> returnSubsets, int currIndex) {
        if(currIndex == nums.length)
        {
            returnSubsets.add(subsetEntry);
            return;
        }
        subsetEntry.add(nums[currIndex]);
        create_subsets(nums,subsetEntry,returnSubsets,currIndex+1);
        subsetEntry.remove(currIndex);
        create_subsets(nums,subsetEntry,returnSubsets,currIndex+1);
    }
}
