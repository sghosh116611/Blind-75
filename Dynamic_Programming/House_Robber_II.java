package Dynamic_Programming;

import java.util.ArrayList;

public class House_Robber_II {
    public int rob(int[] nums) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        if(nums.length==1)
            return nums[0];
    
        for(int i = 0; i < nums.length; i++){
        
            if(i != 0) arr1.add(nums[i]);
            if(i != nums.length - 1) arr2.add(nums[i]);
        }
    
        int ans1 = fTabulationSpaceOptimise(arr1.size() - 1, arr1);
        int ans2 = fTabulationSpaceOptimise(arr2.size() - 1, arr2);
    
        return Math.max(ans1,ans2);
    }

    public int fTabulationSpaceOptimise(int idx, ArrayList<Integer> nums){
        int prev = nums.get(0);
        int prev2 = 0;
        int current = 0;

        for(int i = 1; i <= idx; i++){
            int notTake = 0 + prev;
            
            int take = nums.get(i);
            if(i > 1)
                take += prev2;
            
            current = Math.max(notTake,take);

            prev2 = prev;
            prev = current;
        }
        return prev;
    }
}
