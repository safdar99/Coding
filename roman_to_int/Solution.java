import java.util.*;

class Solution {

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    static HashMap<Character, Integer> romanMap;
    static {
        romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public int romanToInt(String s) {
        int ans = 0;
        int prevNo = 0;
        for (int i = s.length()-1; i > -1; i--) {
            int digit  = romanMap.get(s.charAt(i));
            if (digit < prevNo) ans -= digit;
            else ans += digit;
            prevNo = digit;
        }    
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.romanToInt("MCMXCIV"));
    }
}