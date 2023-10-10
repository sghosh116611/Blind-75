package DataStructures;

public class Longest_Repeating_Character_Substring {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int max = 0, maxFreqInWindow = 0;
        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreqInWindow = Math.max(maxFreqInWindow, freq[s.charAt(right) - 'A']);

            int charactersToReplace = (right - left + 1) - maxFreqInWindow;
            if (charactersToReplace > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}

// Note

// 1. Sliding window technique - Check for maximum occuring character in the
// window and infer the characters that needs to be replaced. If characters to
// be replaced > k it means we have to shift our window.
