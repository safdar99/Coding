import java.util.Arrays;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int minPathSum(int[][] a) {
        int m = a.length, n = a[0].length;
        for (int k = 1; k < n; k++) {
            a[0][k] += a[0][k-1];
        }
        for (int k = 1; k < m; k++) {
            a[k][0] += a[k-1][0];
        }
        int i = 1, j = 1;
        while (i != m && j != n) {
            for (int k = j; k < n; k++) {
                a[i][k] += Math.min(a[i-1][k], a[i][k-1]);
            }
            for (int k = i+1; k < m; k++) {
                a[k][j] += Math.min(a[k-1][j], a[k][j-1]);
            }
            i++; j++;
        }
        // for (int[] x: a) {
        //     po(x);
        // }
        return a[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.minPathSum(new int[][] {
            {6},
            // {4,2,1}
        }));
    }
}