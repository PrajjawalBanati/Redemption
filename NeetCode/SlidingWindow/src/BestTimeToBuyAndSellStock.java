public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buyingPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < n; i++)
        {
            int profit = prices[i] - buyingPrice;
            if(profit < 0)
            {
                buyingPrice = prices[i];
            }
            else {
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}
