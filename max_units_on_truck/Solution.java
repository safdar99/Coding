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
        int count = t.length();
        int p1 = 0, p2 = 0, min = Integer.MAX_VALUE;
        String ans = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) addInMap(map, t.charAt(i));
        while (p2 < s.length()) {
            char c = s.charAt(p2++);
            if (removeFromMap(map, c) >= 0) count--; //decrease the count if the char matched is not extranneous
            while (count == 0) {                     //till the current window is valid
                if (min > (p2-p1)) {
                    min = p2-p1;                
                    ans = s.substring(p1, p2);
                }
                c = s.charAt(p1++);
                if (map.containsKey(c)) {           //if the map contains this char its count will be increased
                    if (map.get(c) == 0) count++;   //if the count of this char is already zero that means there is no extranneous char hence invalidate count
                    addInMap(map, c);
                }
            }
        }
        return ans;
    }

    void addInMap(Map<Character, Integer> map, char c) {
        Integer count = map.get(c);
        if (count == null) map.put(c, 1);
        else map.put(c, ++count);
    }

    int removeFromMap(Map<Character, Integer> map, char c) {
        Integer count = map.get(c);
        if (count == null) return -1;
        else map.put(c, --count);
        return map.get(c);
    }
    public static void main(String[] args) {
        Solution s =  new Solution();
        po(s.minWindow("mynameissafdarali", "fli"));
    }
}