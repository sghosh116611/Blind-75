package Sequence;
import java.util.Arrays;

public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] == nums[i + 1])
                return true;
        return false;
    }
}

// Note
// 1. Sort and two pointers - O(nlogn) + O(1)
// 2. HashMap - O(n) + O(n)
