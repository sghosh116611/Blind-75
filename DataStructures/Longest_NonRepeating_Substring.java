package DataStructures;

import java.util.HashSet;

public class Longest_NonRepeating_Substring {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int low = 0;
        int max = 0;
        for (int high = 0; high < s.length(); high++) {
            if (set.contains(s.charAt(high))) {
                while (low < high && set.contains(s.charAt(high))) {
                    set.remove(s.charAt(low));
                    low++;
                }
            }
            set.add(s.charAt(high));
            max = Math.max(max, high - low + 1);
        }
        return max;
    }

}

// Note
// 1. we have a sliding window approach where the window contains only unique elements. 
// 2. When we get a repeating element we remove the elements from the window till that particular element