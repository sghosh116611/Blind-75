package Dynamic_Programming;

public class Jump_Game {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int i = 0;
        for(int maximum = 0; i < n && i <= maximum; i++){
            maximum = Math.max(nums[i] + i,maximum);
        }
        return i == n;
    }
}

// Note
// 1. Maintain a maximum point we can reach from each index
// 2. Update this maximum as necessary
// 3. for every index it should be <= maximum
