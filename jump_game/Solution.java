import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public boolean canJump(int[] nums) {
        int curLimit = nums[0];
        int curFar = nums[0];
        int jump = 0;
        for (int i = 0; i < nums.length; i++) {
            curFar = Math.max(i+nums[i], curFar);
            if (curFar == i && i < nums.length-1) return false;
            if (i == curLimit) {
                curLimit = curFar;
                jump++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.canJump(new int[]{0}));
    }
}