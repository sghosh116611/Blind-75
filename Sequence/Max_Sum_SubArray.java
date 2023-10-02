package Sequence;
public class Max_Sum_SubArray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0)
                sum = 0;
        }

        return maxSum;
    }
}

// Note 
// 1. Use kadane's algorithm to find the maxSum till a point
