import java.util.*;
import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
    
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean isFirstRowZero = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    if (i == 0) isFirstRowZero = true;
                }
            }
        }
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < rows; i++) {
                    if (matrix[i][j] == 0) {
                        for (int k = 0; k < cols; k++) {
                            matrix[i][k] = 0;
                        }
                    } else matrix[i][j] = 0;
                }
            }
        }
        if (isFirstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
        for (int[] a: matrix) {
            po(a);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.setZeroes(new int[][] {
            // {0,1,2,0},{3,4,5,2},{1,3,1,5}
            {1,1,1},{1,0,1},{1,1,1}
        });
    }
}