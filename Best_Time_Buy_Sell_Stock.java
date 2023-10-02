class Best_Time_Buy_Sell_Stock {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = 0;
        for (int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            sell = Math.max(sell, prices[i] - buy);
        }

        return sell;
    }
}

// Note
// 1. Two loops
// 2. HashMap to store the max element to the right of i
// 3. Maintain two variables buy and sell to buy at minimum and sell at the
// maximum profit. O(n) + O(1)
