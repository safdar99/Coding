import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int charCounts[][] = new int[strs.length][26];
        boolean isIncluded[] = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            for (int j = 0; j < s.length(); j++) {
                int charIndex = s.charAt(j) - 97;
                charCounts[i][charIndex]++;
            }
        }
        for (int i = 0; i < strs.length; i++) {
            if (isIncluded[i]) continue;
            int charCount1[] = charCounts[i];
            List<String> subAns = new ArrayList<>();
            subAns.add(strs[i]);
            isIncluded[i] = true;
            for (int j = i+1; j < strs.length; j++) {
                if (isIncluded[j]) continue;
                int charCount2[] = charCounts[j];
                for (int k = 0; k < 26; k++) {
                    if (charCount1[k] != charCount2[k]) break;
                    if (k == 25) {
                        subAns.add(strs[j]);
                        isIncluded[j] = true;
                    }
                }
            }
            ans.add(subAns);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.groupAnagrams(new String[]{
            "my", "name", "ist", "safdar",
            "ym", "anme", "tsi", "safdar", 
            "ym", "eanm", "sit", "safdar"}));
    }
}