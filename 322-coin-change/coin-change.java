class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n][amount + 1];
        
        int result = fDP(n - 1,amount,coins,dp);
        if(result >= (int) Math.pow(10, 9))
            return -1;
        return result;
    }

    private int f(int n, int amount, int[] coins){
        if(n == 0){
            if(amount % coins[0] == 0)
                return amount / coins[0];
            else
                return Integer.MAX_VALUE;
        }

        int notTake = 0 + f(n - 1,amount,coins);
        int take = Integer.MAX_VALUE;
        if(coins[n] <= amount)
            take = 1 + f(n, amount - coins[n],coins);

        return Math.min(notTake,take);
    }

    private int fDP(int n, int amount, int[] coins, int[][] dp){
        if(n == 0){
            if(amount % coins[0] == 0)
                return amount / coins[0];
            else
                return (int) Math.pow(10, 9);
        }
        if(dp[n][amount] != 0)
            return dp[n][amount];
        
        int notTake = 0 + fDP(n - 1,amount,coins,dp);
        int take = (int) Math.pow(10, 9);
        if(coins[n] <= amount)
            take = 1 + fDP(n, amount - coins[n],coins,dp);

        return dp[n][amount] = Math.min(notTake,take);
    }
}