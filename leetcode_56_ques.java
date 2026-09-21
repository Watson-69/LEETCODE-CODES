import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_56_ques {
    class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        List<int[]> adder=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            int s=intervals[i][0];
            int e=intervals[i][1];
            if(s<=end){
               end = Math.max(e, end);
            }
            else{
                adder.add(new int[]{start,end});
                start=s;
                end=e;
            }
        }
        adder.add(new int[]{start,end});
        return adder.toArray(new int[adder.size()][]);
    }
}
}
