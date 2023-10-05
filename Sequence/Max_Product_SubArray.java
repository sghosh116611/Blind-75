package Sequence;

public class Max_Product_SubArray {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) // prod is 0
                prefix = 1;
            if (suffix == 0) // prod is 0
                suffix = 1;
            prefix *= nums[i]; // prefix prod
            suffix *= nums[nums.length - 1 - i]; // suffix prod
            result = Math.max(result, Math.max(prefix, suffix));
        }

        return result;
    }
}
