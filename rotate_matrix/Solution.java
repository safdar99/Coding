import java.util.Arrays;

class Solution {

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public void rotate(int[][] mat) {
        int size = mat.length;
        int k = 1;
        while (k <= size / 2) {
            int ai = k-1, aj = k-1;
            int bi = k-1, bj = size - k;
            int ci = size - k, cj = size - k;
            int di = size - k, dj = k-1;
            int limit = bj;
            while (aj < limit) {
                int t = mat[ai][aj];
                mat[ai][aj] = mat[di][dj];
                mat[di][dj] = mat[ci][cj];
                mat[ci][cj] = mat[bi][bj];
                mat[bi][bj] = t;
                aj++;
                bi++;
                ;
                cj--;
                di--;
            }
            k++;
        }
        // printMat(mat);
    }

    void printMat(int[][] mat) {
        for (int[] a : mat) {
            po(a);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][] { 
            {10, 20, 30, 40, 50},
            { 5, 1, 9, 11, 60 },
            { 2, 4, 8, 10, 70},
            { 13, 3, 6, 7, 80 }, 
            { 15, 14, 12, 16, 90 } };
        s.rotate(matrix);
    }
}