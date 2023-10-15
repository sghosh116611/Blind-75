package NonLinearDataStructure;

import java.util.*;

public class Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = bucketSort(nums, k);
        return res;
    }

    // Bucket Sort O(n) + O(n)
    private int[] bucketSort(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        int tempK = k;

        // Count frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Create bucket where idx of bucket is the frequency
        List<Integer>[] bucket = new List[nums.length + 1];

        // Add the elements to the bucket
        for (int n : map.keySet()) {
            int freq = map.get(n);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(n);
        }

        // Find the elements with most frequency
        for (int i = bucket.length - 1; i > 0 && k > 0; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }

        // Corner case: In case elements are not unique and the result list contains
        // number of elements more than K, we need to print only the K elements
        result = result.subList(0, tempK);

        int[] resArr = result.stream().mapToInt(i -> i).toArray();
        return resArr;
    }
}
