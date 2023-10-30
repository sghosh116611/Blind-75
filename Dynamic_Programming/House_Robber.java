package Dynamic_Programming;


import java.util.Arrays;

public class House_Robber {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);

        // Recurrence
        //return f(nums.length -1 , nums); 

        // Memoization
        //return fMemoization(nums.length - 1, nums,dp);

        // Tabulation
        //return fTabulation(nums.length - 1, nums,dp);

        // Space optimisation
        return fTabulationSpaceOptimise(nums.length - 1, nums,dp);
    }

    public int f(int idx, int[] nums){
        if(idx == 0)
            return nums[0];
        
        if(idx == -1)
            return 0;
        
        int notTake = 0 + f(idx - 1,nums);
        int take = nums[idx] + f(idx - 2,nums);

        return Math.max(notTake,take);
    }

    public int fMemoization(int idx, int[] nums, int[] dp){
        if(idx == 0)
            return nums[idx];
        
        if(idx == -1)
            return 0;
        
        if(dp[idx] != -1)
            return dp[idx];

        int notTake = 0 + f(idx - 1,nums);
        int take = nums[idx] + f(idx - 2,nums);

        return dp[idx] = Math.max(notTake,take);
    }

    public int fTabulation(int idx, int[] nums, int[] dp){
        dp[0] = nums[0];

        for(int i = 1; i <= idx; i++){
            int notTake = 0 + dp[i - 1];
            
            int take = nums[i];
            if(i > 1)
                take += dp[i - 2];
            
            dp[i] = Math.max(notTake,take);
        }

        return dp[idx];
    }

    public int fTabulationSpaceOptimise(int idx, int[] nums, int[] dp){
        int prev = nums[0];
        int prev2 = 0;
        int current = 0;

        for(int i = 1; i <= idx; i++){
            int notTake = 0 + prev;
            
            int take = nums[i];
            if(i > 1)
                take += prev2;
            
            current = Math.max(notTake,take);

            prev2 = prev;
            prev = current;
        }
        return prev;
    }
}
