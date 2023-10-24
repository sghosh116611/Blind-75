package MoreDataStructure;

import java.util.HashSet;

public class Longest_Consequtive_Sequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for(int num:nums)
            set.add(num);
        
        for(int num : nums){
            if(!set.contains(num - 1)) // if num - 1 is not present in set then it is the first element of the sequence
            {
                int startingPoint = num;
                int count = 0;
                while(set.contains(startingPoint)){
                    set.remove(startingPoint);
                    startingPoint++;
                    count++;
                }
                result = Math.max(count,result);
            }
        }

        return result;
    }
}
