package Sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) // To check for first positive
                break;
            if(i > 0 && nums[i] == nums[i-1]) // To identify unique solution for every nums[i]
                continue;
            int k = -1 * nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high){
                int sum = nums[low] + nums[high];
                if(sum == k){
                    List triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[low]);
                    triplet.add(nums[high]);
                    result.add(triplet);
                    while(low < high && nums[low] == nums[low+1]) // To skip every occurence of duplicate solution
                        low++;
                    while(low < high && nums[high] == nums[high-1])
                        high--;
                    low++;
                    high--;
                }else if(sum < k){
                    low++;
                }else
                    high--;
            }
        }

        return result;
    }
}

// Note-
// 1. Sort array and then two pointers O(n*n) + O(1)