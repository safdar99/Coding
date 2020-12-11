import java.util.*;

class Solution {

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int myAtoi(String s) {
        char c = s.charAt(0);
        if (c != '-'&& c != '+' && c != ' ' && c < '0' && c > '9') return 0; 
        int ans = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                c = s.charAt(i);
                if (c == '+' || c == '-' || (c >= '0' && c <= '9')) break;
            }
        }
        po((int)' ');

        c = s.charAt(i);
        boolean isNegative = c == '-';
        if (c == '-' || c == '+') i++;
        while (i < s.length()) {
            c = s.charAt(i++);
            if (c < '0' || c > '9') return ans;
            int digit = isNegative ? -(c-48) : (c-48);
            po(ans, digit);
            if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE && digit > 7)) return Integer.MAX_VALUE;
            if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE && digit < -8)) return Integer.MIN_VALUE;
            ans = ans*10 + digit;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.myAtoi("words and 987"));    
    }
}