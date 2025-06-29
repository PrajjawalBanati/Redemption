import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
* Given an integer array nums and an integer k, return the k most frequent elements within the array.
* The test cases are generated such that the answer is always unique.
* You may return the output in any order.
* Example 1:
* Input: nums = [1,2,2,3,3,3], k = 2
* Output: [2,3]
*
* Example 2:
* Input: nums = [7,7], k = 1
* Output: [7]
*
* Constraints:
* 1 <= nums.length <= 10^4.
* -1000 <= nums[i] <= 1000
* 1 <= k <= number of distinct elements in nums
* */
public class TopKFrequentElements {
    public int[] topKFrequency(int[] nums, int k)
    {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        HashMap<Integer, Integer> hmp = new HashMap<>();
        for(int i: nums)
        {
            hmp.computeIfAbsent(i, m->0);
            hmp.put(i, hmp.get(i)+1);
        }
        pq.addAll(hmp.entrySet());
        int[] ans = new int[k];
        int i = 0;
        while(k > 0)
        {
            ans[i] = pq.poll().getKey();
            i++;
            k--;
        }
        return ans;
    }
}
