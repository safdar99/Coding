import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    void print(int[] a) {
        int c = 97;
        for (int x: new int[26]) {
            System.out.print((char)(c++) + " ");
        }
        System.out.println();
        for (int x: a) {
            System.out.print(x + " ");    
        }
        System.out.println();
    }
    
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            addInMap(tMap, t.charAt(i));
        }
        int p1 = 0;
        String ans = "";
        int min = Integer.MAX_VALUE;
        while (p1 < s.length()) {
            char c = s.charAt(p1);
            if (tMap.containsKey(c)) {
                Map<Character, Integer> sMap = new HashMap<>();
                addInMap(sMap, c);
                int count = 1;
                int p2 = p1+1;
                while (count < t.length() && p2 < s.length()) {
                    c = s.charAt(p2);
                    if (tMap.containsKey(c)) {
                        addInMap(sMap, c);
                        if (sMap.get(c) <= tMap.get(c)) {
                            count++;
                        }
                    } 
                    p2++;
                }
                //remove unnecessary chars from beginning
                c = s.charAt(p1);
                while (!tMap.containsKey(c) || sMap.get(c) > tMap.get(c)) {
                    removeFromMap(sMap, c);
                    p1++;
                    c = s.charAt(p1);
                }
                if (count == t.length() && min > (p2-p1)) {
                    ans = s.substring(p1, p2);
                    min = p2-p1;
                }
            }
            p1++;
        }
        return ans;
    }

    void addInMap(Map<Character, Integer> map, char c) {
        Integer count = map.get(c);
        if (count == null) map.put(c, 1);
        else map.put(c, ++count);
    }

    void removeFromMap(Map<Character, Integer> map, char c) {
        Integer count = map.get(c);
        if (count != null) map.put(c, --count);    
    }
    public static void main(String[] args) {
        Solution s =  new Solution();
        po(s.minWindow("cabwefgewcwaefgcf", "gcf"));
    }
}