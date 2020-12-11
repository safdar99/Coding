import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int[] searchRange(int[] a, int x) {
        int[] ans = {-1, -1};
        int s = 0;
        int e = a.length-1;
        while (s <= e) {
            int mid = (s+e)/2;
            if (a[mid] == x) {
                if (mid == 0) {
                    ans[0] = mid;break;
                }
                else if (a[mid-1] != a[mid]) {
                    ans[0] = mid;break;
                } else {
                    e = mid-1;
                }
            } else if (a[mid] < x) {
                s = mid+1;
            } else {
                e = mid-1;
            }
        }
        s = 0;
        e = a.length-1;
        po("first rn");
        while (s <= e) {
            int mid = (s+e)/2;
            if (a[mid] == x) {
                if (mid == a.length-1) {
                    ans[1] = mid;break;
                }
                else if (a[mid] != a[mid+1]) {
                    ans[1] = mid;break;
                } else {
                    s = mid+1;
                }
            } else if (a[mid] < x) {
                s = mid+1;
            } else {
                e = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,2,3,4,5,6,7,7,7,7,7};
        int target = 7;
        po(s.searchRange(nums, target));
    }
}