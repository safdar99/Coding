import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        dp[m-1][n-1] = 1;
        return getNumberOfWaysFrom(0, 0, m, n, "");
    }

    int getNumberOfWaysFrom(int i, int j, int m, int n, String pad) {
        if (i == m || j == n) return 0;
        // po(pad, i, j);
        if (dp[i][j] != 0) return dp[i][j];
        int fromRight = getNumberOfWaysFrom(i, j+1, m, n, pad + "    ");
        int fromDown = getNumberOfWaysFrom(i+1, j, m, n, pad + "    ");
        dp[i][j] = fromRight + fromDown;
        return dp[i][j];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.uniquePaths(2,2));
    }
}