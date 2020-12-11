import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int search(int[] nums, int target) {
        int pivot = getPivot(nums);
        if (pivot == -1) {
            return bs(nums, 0, nums.length-1, target);
        }
        if (target < nums[0]) {
            return bs(nums, pivot+1, nums.length-1, target);
        } else {
            return bs(nums, 0, pivot, target);
        }
    }

    int getPivot(int[] a) {
        int s = 0, e = a.length-1;
        int pivot = -1;
        while(s <= e) {
            int mid = (s+e)/2;
            if (mid == a.length-1) return -1;
            if (a[mid] > a[mid+1]) {
                pivot =  mid;
                break;
            } else if (a[s] > a[mid]) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        return pivot;
    }

    int bs(int[] a, int s, int e, int x) {
        int ans = -1;
        while (s <= e) {
            int mid = (s+e)/2;
            if (a[mid] == x) {
                ans = mid;
                break;
            } else if (a[mid] > x) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {16};
        int target = 16;
        po(s.search(nums, target));
    }
}