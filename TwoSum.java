import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int k = target - nums[i];
            if (map.containsKey(k) && map.get(k) != i)
                return new int[] { i, map.get(k) };
        }

        return new int[2];
    }
}

// Note
// 1. Sort array and two pointers - O(nlogn) + O(1)
// 2. Maintain HashMap - O(n) + O(n)