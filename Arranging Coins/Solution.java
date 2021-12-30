import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int arrangeCoins(int n) {
        double ans = (Math.sqrt(1+8L*n)-1) / 2;
        return (int)Math.abs(ans);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        po(sol.arrangeCoins(1804289383));
    }
}