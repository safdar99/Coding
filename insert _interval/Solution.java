import java.util.*;

class Solution {

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        int[][] ans = new int[intervals.length][2];
        ans[0] = intervals[0];
        int lastUpdatedIndex = 0;
        for (int[] interval: intervals) {
            int e1 = ans[lastUpdatedIndex][1];
            int s2 = interval[0], e2 = interval[1];
            if (s2 <= e1) {
                ans[lastUpdatedIndex][1] = Math.max(e1, e2);
            } else {
                ans[++lastUpdatedIndex] = interval;
            }
        }
        // po(intervals);
        int[][] finalAns = new int[lastUpdatedIndex+1][2];
        for (int i = 0; i <= lastUpdatedIndex; i++) {
            finalAns[i] = ans[i];
        }
        // po(finalAns);
        return finalAns;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.insert(new int[][] {

        }, new int[]{}));    
    }
}