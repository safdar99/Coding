import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public String addBinary(String a, String b) {
        int l1 = a.length()-1;
        int l2 = b.length()-1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while (l1 >= 0 && l2 >= 0) {
            int d1 = a.charAt(l1--) - 48;
            int d2 = b.charAt(l2--) - 48;
            int sum = d1 + d2 + carry;
            carry = sum / 10;
            switch (sum) {
                case 0: ans.append('0'); carry = 0; break;
                case 1: ans.append('1'); carry = 0; break;
                case 2: ans.append('0'); carry = 1; break;
                case 3: ans.append('1'); carry = 1; break;
            }
        }
        while (l1 >= 0) {
            int d = a.charAt(l1--) - 48;
            int sum = d + carry;
            switch (sum) {
                case 0: ans.append('0'); carry = 0; break;
                case 1: ans.append('1'); carry = 0; break;
                case 2: ans.append('0'); carry = 1; break;
                case 3: ans.append('1'); carry = 1; break;
            }
        } 
        while (l2 >= 0) {
            int d = b.charAt(l2--) - 48;
            int sum = d + carry;
            switch (sum) {
                case 0: ans.append('0'); carry = 0; break;
                case 1: ans.append('1'); carry = 0; break;
                case 2: ans.append('0'); carry = 1; break;
                case 3: ans.append('1'); carry = 1; break;
            } 
        }
        if (carry == 1) ans.append('1');
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.addBinary("100", "11101"));
    }
}