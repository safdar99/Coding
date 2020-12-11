import jdk.dynalink.beans.StaticClass;
import java.util.*;

class Solution2 {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    String ans;

    public String longestPalindrome(String s) {
        ans = "";
        for (int i = 0; i < s.length(); i++) {
            expandPal(s, i, i);
            if (i < s.length() - 1)
                expandPal(s, i, i + 1);
        }
        return ans;
    }

    void expandPal(String s, int center1, int center2) {
        if (s.charAt(center1) == s.charAt(center2)) {
            int len = center2 - center1 + 1;
            if (ans.length() < len) {
                ans = s.substring(center1, center2 + 1);
            }
            int left = center1 - 1;
            int right = center2 + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                po(left, center1, center2, right);
                len = right - left + 1;
                if (ans.length() < len) {
                    ans = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        po(s.longestPalindrome(""));
    }
}