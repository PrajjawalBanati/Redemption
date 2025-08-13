import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        HashSet<List<Integer>> combinations = new HashSet<>();
        List<Integer> numsUsed = new ArrayList<>();
        findCombinations(nums, numsUsed, combinations, target, 0);
        List<List<Integer>> addAllNums = new ArrayList<>();
        for(List<Integer> lis : combinations){
            addAllNums.add(new ArrayList<>(lis));
        }
        return addAllNums;
    }

    private void findCombinations(int[] nums, List<Integer> numsUsed, HashSet<List<Integer>> combinations, int target, int index) {
        if(index == nums.length)
        {
            return;
        }
        if(target == 0)
        {
            numsUsed.sort((a,b)->a-b);
            combinations.add(new ArrayList<>(numsUsed));
        }
        else if(target < 0)
        {
            target += numsUsed.get(numsUsed.size()-1);
            numsUsed.remove(numsUsed.size()-1);
            findCombinations(nums, numsUsed, combinations, target, index+1);
        }
        else {
            numsUsed.add(nums[index]);
            findCombinations(nums, numsUsed, combinations, target-nums[index], index);
            numsUsed.remove(numsUsed.size()-1);
            findCombinations(nums, numsUsed, combinations, target, index+1);
        }
    }
}
