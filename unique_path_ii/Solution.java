import java.util.Arrays;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int uniquePathsWithObstacles(int[][] a) {
        int m = a.length, n = a[0].length;
        int i = 0, j = 0;
        a[0][0] = 1;
        for (int k = 1; k < n; k++) {
            if (a[i][k] == 1) a[i][k] = 0;
            else a[i][k] = a[i][k-1];
        }
        for (int k = 1; k < m; k++) {
            if (a[k][j] == 1) a[k][j] = 0;
            else a[k][j] = a[k-1][j];
        }
        i++;j++;
        while (i != m && j != n) {
            for (int k = j; k < n; k++) {
                if (a[i][k] == 1) {
                    a[i][k] = 0;
                } else {
                    int ups = a[i - 1][k];
                    int lefts = a[i][k - 1];
                    a[i][k] = ups + lefts;
                }
            }
            for (int k = i+1; k < m; k++) {
                if (a[k][j] == 1)
                    a[k][j] = 0;
                else {
                    int ups = a[k - 1][j];
                    int lefts = a[k][j - 1];
                    a[k][j] = ups + lefts;
                }
            }
            i++;
            j++;
        }
        // for (int[] x: a) {
        //     po(x);
        // }
        return a[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.uniquePathsWithObstacles(new int[][] { { 0, 1}, { 0, 0} }));
    }
}