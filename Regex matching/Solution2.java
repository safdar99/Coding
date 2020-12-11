import java.util.*;

class Solution2 {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public boolean isMatch(String str, String pat) {
        if (pat.isEmpty()) return str.isEmpty();
        boolean[][] dp = new boolean[str.length()+1][pat.length()+1];
        dp[0][0] = true;        //empty string matches empty pattern
        dp[0][1] = false;       //empty string doesnt matches pattern with a single character
        for (int i = 1; i <= str.length(); i++) {
            dp[i][0] = false;   //non empty string doesnt matches empty pattern
        }
        for (int j = 2; j <= pat.length(); j++) {
            dp[0][j] = pat.charAt(j-1) == '*' ? dp[0][j-2] : false;
        }
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= pat.length(); j++) {
                char s = str.charAt(i-1), p = pat.charAt(j-1);
                if (s == p || p == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p == '*') {
                    if (dp[i][j-2]) {
                        dp[i][j] = dp[i][j-2];  //matching by removing the kleene star for zero occurences
                        continue;
                    } 
                    char prevCharInPat = pat.charAt(j-2); 
                    if (s == prevCharInPat || prevCharInPat == '.') {
                        dp[i][j] = dp[i-1][j];  //current char in string matches the kleene start now the prev string should match therefore removing currenct char and checking
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[str.length()][pat.length()];
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        po(s.isMatch("a", ""));
    }
}