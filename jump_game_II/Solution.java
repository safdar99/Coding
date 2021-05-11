import java.util.Arrays;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int jump(int[] a) {
        int curMax = 0, curEnd = Math.min(a[0], a.length-1), jump = 0;
        for (int i = 1; i < a.length; i++) {
            curMax = Math.max(curMax, i+a[i]);
            if (i == curEnd) {
                curEnd = Math.min(curMax, a.length-1);
                jump++;
            }
        }
        return jump;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.jump(new int[]{1}));
    }
}