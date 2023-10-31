class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int i = 0;
        for(int maximum = 0; i < n && i <= maximum; i++){
            maximum = Math.max(nums[i] + i,maximum);
        }
        return i == n;
    }
}