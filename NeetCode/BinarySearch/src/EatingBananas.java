/**
 * You are given an integer array piles where piles[i] is the number of bananas in the ith pile. You are also given an
 * integer h, which represents the number of hours you have to eat all the bananas.<br/><br/>
 * You may decide your bananas-per-hour eating rate of k. Each hour, you may choose a pile of bananas and eats k bananas
 * from that pile. If the pile has less than k bananas, you may finish eating the pile but you can not eat from another
 * pile in the same hour.<br/><br/>
 * Return the minimum integer k such that you can eat all the bananas within h hours.<br/><br/>
 * Example 1: <br/>
 * Input: piles = [1,4,3,2], h = 9 <br/>
 * Output: 2 <br/>
 * Explanation: With an eating rate of 2, you can eat the bananas in 6 hours. With an eating rate of 1, you would need
 * 10 hours to eat all the bananas (which exceeds h=9), thus the minimum eating rate is 2.<br/><br/>
 * Example 2: <br/>
 * Input: piles = [25,10,23,4], h = 4 <br/>
 * Output: 25 <br/><br/>
 * Constraints: <br/>
 * 1 <= piles.length <= 1,000<br/>
 * piles.length <= h <= 1,000,000<br/>
 * 1 <= piles[i] <= 1,000,000,000<br/>
 */
public class EatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int maxEatingSpeed = Integer.MIN_VALUE;
        for(int num:piles)
        {
            maxEatingSpeed = Math.max(num, maxEatingSpeed);
        }
        int l = 1, r = maxEatingSpeed;
        while(l <= r)
        {
            int mid = l + (r-l)/2;
            if(timeTakenToEat(piles,mid) <= h)
            {
                r = mid-1;
            }
            else {
                l = mid+1;
            }

        }
        return l;
    }
    public int timeTakenToEat(int[] piles, int time)
    {
        int totalTime=0;
        for(int num: piles)
        {
            totalTime+=(int)Math.ceil((double)num/time);
        }
        return totalTime;
    }
}
