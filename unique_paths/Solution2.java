import java.util.*;

class Solution2 {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    int[][] dp;
    public int uniquePaths(int mi, int ni) {
        int m = Math.min(mi, ni)-1;
        int n = Math.max(mi, ni)-1;
        int numerator = 1;
        for (int i = (m+n); i > n; i--) {
            numerator *= i;
        }
        int denominator = 1;
        for (int i = 1; i <= m; i++) {
            denominator *= i;
        }
        po(m, n, numerator, denominator);
        return numerator/denominator;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        po(s.uniquePaths(10, 10));
    }
}