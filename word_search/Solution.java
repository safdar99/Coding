import java.util.*;

class Solution {
    static void po(Object... o)  {
        System.out.println(Arrays.deepToString(o));
    }
    
    char[][] board;
    String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                    if (matchWord(i, j, 0, new boolean[m][n], "")) return true;
            }
        }
        return false;
    }
    
    boolean matchWord(int i, int j, int k, boolean[][] visited, String pad) {
        if (visited[i][j]) return false;
        visited[i][j] = true;
        if (board[i][j] == word.charAt(k)) {
            k++;
            if (k == word.length()) return true;
            if (i > 0) {
                if (matchWord(i-1, j, k, deepCopy(visited), pad + "    ")) return true;
            }
            if (j < board[0].length-1) {
                if (matchWord(i, j+1, k, deepCopy(visited), pad + "    ")) return true;
            }
            if (i < board.length-1) {
                if (matchWord(i+1, j, k, deepCopy(visited), pad + "    ")) return true;
            }
            if (j > 0) {
                if (matchWord(i, j-1, k, deepCopy(visited), pad + "    ")) return true;
            }
            return false;
        } else {
            return false;
        }
    }
    
    public static boolean[][] deepCopy(boolean[][] original) {
        final boolean[][] result = new boolean[original.length][];
        for (int i = 0; i < original.length; i++) result[i] = Arrays.copyOf(original[i], original[i].length);
        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.exist(new char[][] {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'F'}
        }, "DFSABC"));
    }

}