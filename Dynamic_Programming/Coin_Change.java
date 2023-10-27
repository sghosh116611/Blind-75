package Dynamic_Programming;

public class Coin_Change {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        int result = fDPTabulation(n,amount,coins,dp);
        if(result >= (int) Math.pow(10, 9))
            return -1;
        return result;
    }

    //recursion
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

    //memoization
    private int fDPMemoization(int n, int amount, int[] coins, int[][] dp){
        if(n == 0){
            if(amount % coins[0] == 0)
                return amount / coins[0];
            else
                return (int) Math.pow(10, 9);
        }
        if(dp[n][amount] != 0)
            return dp[n][amount];
        
        int notTake = 0 + fDPMemoization(n - 1,amount,coins,dp);
        int take = (int) Math.pow(10, 9);
        if(coins[n] <= amount)
            take = 1 + fDPMemoization(n, amount - coins[n],coins,dp);

        return dp[n][amount] = Math.min(notTake,take);
    }

    //Tabulation
    private int fDPTabulation(int n, int amount, int[] coins, int[][] dp){
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = (int) Math.pow(10, 9);
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = 0 + dp[ind - 1][target];
                int take = (int) Math.pow(10, 9);

                if (coins[ind] <= target)
                    take = 1 + dp[ind][target - coins[ind]];

                dp[ind][target] = Math.min(notTake, take);
            }
        }
        return dp[n - 1][amount];
    }
}
