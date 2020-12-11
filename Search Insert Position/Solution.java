import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int searchInsert(int[] a, int x) {
        int s = 0, e = a.length-1;
        if (x < a[0]) return 0;
        while (s < e) {
            int mid = (s+e)/2;
            if (a[mid] == x) return mid;
            else if (a[mid] < x) s = mid+1;
            else e = mid;
        }
        return a[s] >= x ? s : s+1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1};
        int target = 1;
        po(s.searchInsert(nums, target));
    }
}