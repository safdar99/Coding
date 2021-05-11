import java.util.*;
class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
    
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[n] = 1;
        return noOfStepsFrom(0, dp);
    }
    
    int noOfStepsFrom(int n, int[] dp) {
        if (n >= dp.length) return 0;
        else if (dp[n] != 0) return dp[n];
        int opt1 = noOfStepsFrom(n+1, dp);
        int opt2 = noOfStepsFrom(n+2, dp);
        dp[n] = opt1 + opt2;
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.climbStairs(5));
    }
}