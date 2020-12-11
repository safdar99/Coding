import java.util.*;
class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    int[][] dp;
    String ans;
    public String longestPalindrome(String s) {
        ans = "";
        dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length()-1; j > i; j--) {
                checkPal(s, i, j);
            }
        }
        for (int[] list : dp) {
            po(list);
        }
        po(ans);
        return "0";
    }

    boolean checkPal(String s, int i, int j) {
        if (i == j || j < i) return true;
        if (dp[i][j] != 0) return dp[i][j] != -1;
        if (s.charAt(i) == s.charAt(j)) {
            // po(i, j);
            if (checkPal(s, i+1, j-1)) {
                // po(i, j);
                dp[i][j] = j - i + 1;
                if (ans.length() < dp[i][j]) {
                    ans = s.substring(i, j+1);
                }
                return true;
            }
        } 
        dp[i][j] = -1;
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.longestPalindrome("cbbd"));
    }
}