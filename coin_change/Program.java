package coin_change;

import java.util.*;

class Solution {
    static void po(Object... o) {System.out.println(Arrays.deepToString(o));}
    public int coinChange(int[] coins, int amount) {
        StringBuilder mask = new StringBuilder("1");
        for (int i = 0; i < coins.length; i++) {
            mask.app
        }
        return searchForAmt(, coins, coins.length-1, amount);
    }
    

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.coinChange(new int[]{1,2,3}, 10));
    }
}