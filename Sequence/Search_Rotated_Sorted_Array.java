package Sequence;

public class Search_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[low] <= nums[mid]) { // Left Array is sorted
                if (nums[low] <= target && target <= nums[mid]) // Target in between low and mid
                    high = mid - 1;
                else
                    low = mid + 1;
            } else { // Right array is sorted
                if (nums[mid] <= target && target <= nums[high])
                    low = mid + 1; // Target in between mid and high
                else
                    high = mid - 1;
            }
        }

        return -1;
    }
}

// Note
// 1. Check which part of the array is sorted and then modify ccounter saccordingly O(n) + O(1)