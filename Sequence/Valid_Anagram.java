package Sequence;
import java.util.Arrays;

public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i])
                return false;
        }

        return true;
    }
}

// Note
// 1. HashMap to store frequency of evert character O(n) + O(n)
// 2. Sort the two strings and check the characters O(nlogn) + O(n)