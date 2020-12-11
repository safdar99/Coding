import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int ans = 1;
        int p = 0, q = 0;
        HashSet<Character> set = new HashSet<Character>();
        set.add(s.charAt(0));
        int count = 1;
        while (q < s.length()-1) {
            while (q < s.length()-1) {
                q++;
                if (!set.contains(s.charAt(q))) {
                    set.add(s.charAt(q));
                    count++;
                    ans = Math.max(ans, count);
                } else {
                    break;
                }
            }
            while (p < q) {
                set.remove(s.charAt(p));
                count--;
                if (s.charAt(p) != s.charAt(q)) {
                    p++;
                } else {
                    p++;
                    set.add(s.charAt(q));
                    count++;
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans  = s.lengthOfLongestSubstring("abcabcdefbb");
        po(ans);
    }
}