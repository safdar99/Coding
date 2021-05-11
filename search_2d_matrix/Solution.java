import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
    
    public boolean searchMatrix(int[][] mat, int x) {
        int m = mat.length, n = mat[0].length;
        int s = 0, e = m*n - 1;
        while (s <= e) {
            int mid = s + (e-s)/2;
            int val = mat[mid/n][mid%n];
            if (x == val) return true;
            else if (x > val) s = mid + 1;
            else e = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.searchMatrix(new int[][] {
            {1,3}
        }, 3));    
    }
}