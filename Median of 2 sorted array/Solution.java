import java.util.*;

class Solution {

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] x, y;
        if (nums1.length > nums2.length) {
            x = nums2; y = nums1;
        } else {
            x = nums1; y = nums2;
        }
        double ans = 0;
        int nx = x.length, ny = y.length;
        int n = nx + ny;
        int nl = (n + 1)/2;
        int px, py, maxXl, maxYl, minXr, minYr;
        int start = 0, end = x.length-1;
        while (true) {
            if (end == -1) {
                px = -1;
            } else {
                px = (start + end)/2;
            }
            py = nl - px - 2;
            maxXl = px != -1 ? x[px] : Integer.MIN_VALUE;
            minXr = px == nx-1 ? Integer.MAX_VALUE : x[px+1];
            maxYl = py != -1 ? y[py] : Integer.MIN_VALUE;
            minYr = py == ny-1 ? Integer.MAX_VALUE : y[py+1];
            po(start, end, px, py, maxXl, minXr, maxYl, minYr);
            if (maxXl <= minYr && maxYl <= minXr) {
                if (n%2 == 0) {
                    double sum = Math.max(maxXl, maxYl) + Math.min(minXr, minYr) + 0.0;
                    ans = sum/2.0;
                } else {
                    ans = Math.max(maxXl, maxYl);
                }
                break;
            } else if (maxXl > minYr) {
                end = px-1;
            } else {
                start = px+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1};
        int[] b = {1};
        po(s.findMedianSortedArrays(a, b));
    }
}