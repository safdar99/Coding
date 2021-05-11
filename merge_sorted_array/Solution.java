import java.util.*;
class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m-1;
        int tail2 = n-1;
        int finalTail = m+n-1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finalTail--] = nums1[tail1] >= nums2[tail2] ? nums1[tail1--] : nums2[tail2--];
        }
        while (tail1 >= 0) {
            nums1[finalTail--] = nums1[tail1--];
        }
        while (tail2 >= 0) {
            nums1[finalTail--] = nums2[tail2--];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[] {0};
        int[] b = new int[]{1};
        s.merge(a, 0, b, 1);
        po(a);
    }
}
