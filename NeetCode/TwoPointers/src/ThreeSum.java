import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int aLength = nums.length;
        Arrays.sort(nums);
        HashSet<List<Integer>> ans = new HashSet<>();
        int i = 0;
        while(i <  aLength)
        {
            int firstNum = nums[i];
            int pointerOne = i+1;
            int pointerTwo = aLength - 1;
            while(pointerOne < pointerTwo)
            {
                int sum = nums[pointerOne] + nums[pointerTwo];
                if(sum+firstNum == 0)
                {
                    List<Integer> entry = new ArrayList<>(List.of(nums[pointerOne], nums[pointerTwo], nums[i]));
                    ans.add(entry);
                    pointerOne++;
                    pointerTwo--;
                }
                else if (sum+firstNum < 0) {
                    pointerOne++;
                }
                else {
                    pointerTwo--;
                }
            }
            i++;
        }
        return ans.stream().toList();
    }
}
