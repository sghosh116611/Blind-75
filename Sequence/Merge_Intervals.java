package Sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] newInterval = intervals[0];
        mergedIntervals.add(newInterval);
        for(int[] interval:intervals){
            if(interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }else{
                newInterval = interval;
                mergedIntervals.add(newInterval);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
