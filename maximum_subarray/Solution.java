import java.util.Arrays;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            max = Math.max(curSum, max);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.maxSubArray(new int[]{-1}));
    }
}