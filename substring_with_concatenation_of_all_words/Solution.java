import java.util.*;

class Solution {

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int k = words[0].length(), n = words.length;
        List<Integer> ans = new LinkedList<>();
        HashMap<String, Integer> mainWordFreq = new HashMap<>();
        for (String word : words) {
            Integer freq = mainWordFreq.get(word);
            if (freq == null) {
                mainWordFreq.put(word, 1);
            } else {
                mainWordFreq.put(word, freq + 1);
            }
        }
        for (int i = 0; i <= s.length() - n*k; i++) {
            HashMap<String, Integer> wordFreq = (HashMap<String, Integer>)mainWordFreq.clone();
            int p1 = i, p2 = p1 + k - 1;
            while (!wordFreq.isEmpty()) {
                String sub = s.substring(p1, p2 + 1);
                Integer freq = wordFreq.get(sub);
                if (freq != null) {
                    if (freq - 1 == 0)
                        wordFreq.remove(sub);
                    else
                        wordFreq.put(sub, freq - 1);
                    p1 += k;
                    p2 += k;
                } else {
                    break;
                }
            }
            if (wordFreq.isEmpty()) ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        po("==========================================================================================================================================================================");
        Solution sl = new Solution();
        String s = "barbarfoofootif";
        String[] words = { "foo", "foo", "tif" };
        po(sl.findSubstring(s, words));
    }
}