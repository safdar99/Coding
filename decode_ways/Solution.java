import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = -1;
        }
        return decodeWays(s, dp, 0);
    }

    int decodeWays(String s, int[] dp, int pointer) {
        if (pointer == s.length())
            return 1;
        if (dp[pointer] != -1) return dp[pointer];
        int no = s.charAt(pointer) - 48;
        if (no > 0 && no < 10) {
            int ways = decodeWays(s, dp, pointer + 1);
            if (pointer < s.length() - 1) {
                int nextNo = s.charAt(pointer + 1) - 48;
                no = no * 10 + nextNo;
                ways += decodeWays(s, dp, pointer + 2);
            }
            dp[pointer] = ways;
        } else {
            dp[pointer] = 0;
        }
        return dp[pointer];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.numDecodings("101"));
    }
}