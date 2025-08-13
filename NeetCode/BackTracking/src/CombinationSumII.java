import java.util.*;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return combinationSum(candidates, target);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        HashSet<List<Integer>> combinations = new HashSet<>();
        List<Integer> numsUsed = new ArrayList<>();
        Arrays.sort(nums);
        findCombinations(nums, numsUsed, combinations, target, 0);
        List<List<Integer>> addAllNums = new ArrayList<>();
        for(List<Integer> lis : combinations){
            addAllNums.add(new ArrayList<>(lis));
        }
        return addAllNums;
    }

    private void findCombinations(int[] nums, List<Integer> numsUsed, HashSet<List<Integer>> combinations, int target, int index) {
        if(target == 0)
        {
            combinations.add(new ArrayList<>(numsUsed));
        }
        else if(index == nums.length )
        {
            return;
        }
        else if(target < 0)
        {
            return;
        }
        else {

            numsUsed.add(nums[index]);
            findCombinations(nums, numsUsed, combinations, target-nums[index], index+1);
            numsUsed.remove(numsUsed.size()-1);
            findCombinations(nums, numsUsed, combinations, target, index+1);
        }
    }
}
