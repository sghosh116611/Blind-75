package Sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> resultList = new ArrayList<>();
        for (String str : strs) {
            String key = getSortedString(str);
            System.out.println(key);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(key, newList);
            }
        }
        for (Map.Entry<String, List<String>> ele : map.entrySet()) {
            resultList.add(ele.getValue());
        }

        return resultList;
    }

    private String getSortedString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

// Note
// 1. Sort the strings and store in map O(n) + O(n)
