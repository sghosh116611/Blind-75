class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return fDPMemoization(0,-1,nums.length,nums,dp);
    }

    public int f(int idx, int prev,int n, int[] arr){
        if(idx == n){
            return 0;
        }

        int notTake = f(idx + 1,prev,n,arr);
        int take = 0;
        if(prev == -1 || arr[idx] > arr[prev]){
            take = 1 + f(idx + 1,idx,n,arr);
        }
        return Math.max(take,notTake);
    }
    public int fDPMemoization(int idx, int prev,int n, int[] arr,int[][]dp){
        if(idx == n){
            return 0;
        }
        if(dp[idx][prev + 1] != -1)
            return dp[idx][prev + 1];

        int notTake = fDPMemoization(idx + 1,prev,n,arr,dp);
        int take = 0;
        if(prev == -1 || arr[idx] > arr[prev]){
            take = 1 + fDPMemoization(idx + 1,idx,n,arr,dp);
        }
        return dp[idx][prev + 1] = Math.max(take,notTake);
    }
}