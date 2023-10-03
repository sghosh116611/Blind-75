package Sequence;

public class Product_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int prod = nums[res.length - 1];
        for (int i = res.length - 2; i >= 0; i--) {
            res[i] = res[i] * prod;
            prod *= nums[i];
        }
        return res;
    }
}

// Note
// 1. Using division method -> Edge case of 0 O(n) + O(1)
// 2. Using prefix Product O(n) + O(n)