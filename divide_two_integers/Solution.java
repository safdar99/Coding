import java.util.*;

    
class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;
        int i = 31;
        long q = 0;
        long D = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        while (i != -1 && D != 0) {
            long qid = d << i;
            if (D >= qid) {
                D -= qid;
                q += 1L << i;
            }
            i--;
        }
        long ans = sign * q;
        return ans < Integer.MAX_VALUE ? sign * (int)q : Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int dividend = 4;
        int divisor = 1;
        po(s.divide(dividend, divisor));
    }
}