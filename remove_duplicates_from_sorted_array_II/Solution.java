import java.util.Arrays;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int removeDuplicates(int[] nums) {
        int p1 = 0, p2 = 1, cc = 1;
        while (p2 < nums.length) {
            if (nums[p2] == nums[p1] && cc == 1) {
                nums[++p1] = nums[p2]; cc = 2;
            } else if (nums[p2] > nums[p1]) {
                nums[++p1] = nums[p2]; cc = 1;
            }
            p2++;
        }
        return p1+1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[]{0,0,0,0,1,1,1,1,2,2,2,3,3,4,4,4,7};
        s.removeDuplicates(a);
        po(a);
        po(a);
    }
}

