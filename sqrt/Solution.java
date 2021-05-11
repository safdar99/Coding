import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
    
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int start = 1, end = x;
        int c = 0;
        while (start < end) {
            int mid = start + (end-start)/2;
            po(start, mid, end);
            if ((mid <= x/mid) && (mid+1) > x/(mid+1)) {
                return mid;
            } else if (mid > x/mid) {
                end = mid;
            } else {
                start = mid+1;
            }
            if (c++ == 10) {
                break;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.mySqrt(36));
    }
}