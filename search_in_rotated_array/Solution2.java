import java.util.*;

class Solution2 {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int search(int[] nums, int target) {
        return bs(nums, 0, nums.length-1, target);    
    }

    int bs(int[] a, int s, int e, int x) {
        if (s > e) return -1;
        int mid = (s+e)/2;
        if (a[mid] == x) return mid;
        if (a[s] < a[mid]) {
            if (a[s] <= x && x <= a[mid]) return bs(a, s, mid, x);
            else return bs(a, mid+1, e, x);
        } else {
            if (a[mid+1] <= x && x <= a[e]) return bs(a, mid+1, e, x);
            else return bs(a, s, mid, x);
        }
    }
    
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 16;
        po(s.search(nums, target));
    }
}