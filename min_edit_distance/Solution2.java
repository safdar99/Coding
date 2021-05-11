import java.util.*;

class Solution2 {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    String w1, w2;
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        w1 = word1;
        w2 = word2;
        int cost = minCost("", word1.length()-1, word2.length()-1, dp);
        for (int[] a: dp) {
            po(a);
        }
        return cost;
    }

    int minCost(String pad, int i, int j, int[][] dp) {
        po(pad, i, j);
        if (i == -1 && j == -1) return 0;
        if (i == -1) return j+1;
        if (j == -1) return i+1;
        if (dp[i][j] != -1) return dp[i][j];
        if (w1.charAt(i) == w2.charAt(j)) {
            dp[i][j] = minCost(pad + "    ", i-1, j-1, dp);
        } else {
            int replace = minCost(pad + "    ", i-1, j-1, dp);
            int delete = minCost(pad + "    ", i, j-1, dp);
            int insert = minCost(pad + "    ", i-1, j, dp);
            // po(replace, delete, insert);
            dp[i][j] = 1 + Math.min(replace, Math.min(delete, insert));
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        po(s.minDistance("intention", "execution"));
    }
}