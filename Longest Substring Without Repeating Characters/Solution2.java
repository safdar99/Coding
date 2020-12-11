import java.util.*;

class Solution2 {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int ans = 1;
        int p = 0, q = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put(s.charAt(0), 0);
        int count = 1;
        while (q < s.length()-1) {
            while (q < s.length()-1) {
                q++;
                if (!map.containsKey(s.charAt(q)) || map.get(s.charAt(q)) < p) {
                    map.put(s.charAt(q), q);
                    count++;
                    ans = Math.max(ans, count);
                } else {
                    int indexOfLastSameChar = map.get(s.charAt(q));
                    count -= (indexOfLastSameChar - p + 1);
                    p = indexOfLastSameChar + 1;
                    map.put(s.charAt(q), q);
                    count++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int ans  = s.lengthOfLongestSubstring("bbbbbb");
        po(ans);
    }
}