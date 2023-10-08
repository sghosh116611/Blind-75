package DataStructures;

public class Minimum_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            if (nums[low] < nums[high])
                return nums[low];
            int mid = low + (high - low) / 2;
            if (nums[low] <= nums[mid])
                low = mid + 1;
            else
                high = mid;
        }

        return nums[low];
    }
}


// Note
// 1. Make a binary search with the following algorithm
// 	a. If nums[low] < nums[high] , we hacve the minimum at nums[low]
// 	b. if nums[low] <= nums[mid] the left array is sorted and we need to move towards right or else we move left