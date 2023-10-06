package DataStructures;

public class Container_Most_Water {
    public int maxArea(int[] height) {
        int n = height.length;
        int high = n - 1;
        int low = 0;
        int max = Integer.MIN_VALUE;
        while (low < high) {
            max = Math.max(Math.min(height[low], height[high]) * (high - low), max);
            if (height[low] < height[high])
                low++;
            else
                high--;
        }

        return max;
    }
}
