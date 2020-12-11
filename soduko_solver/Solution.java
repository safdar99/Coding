import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
    
    public void solveSudoku(char[][] bo) {
        List<HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>();
        List<HashSet<Integer>> cols = new ArrayList<HashSet<Integer>>();
        List<HashSet<Integer>> boxes = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (bo[i][j] != '.') {
                    int x = bo[i][j] - 48;
                    int ij = (i/3) * 3 + j/3;
                    rows.get(i).add(x);
                    cols.get(j).add(x);
                    boxes.get(ij).add(x);
                }
            }
        }
    }

    boolean fill(int i, int j, char[][] bo, List<HashSet<Integer>> rows, List<HashSet<Integer>> cols, List<HashSet<Integer>> boxes) {
        j++;
        if (j == 3) {
            i++;
            if (i == 3) return true;
            j = 0;
        }
        for (int k = 1; k < 10; k++) {
            int ij = (i/3) * 3 + j/3;
            if (canBePut(rows, i, k) && canBePut(cols, j, k) && canBePut(boxes, ij, k)) {
                List<HashSet<Integer>> rows2 = (ArrayList<HashSet<Integer>>) rows.;
                List<HashSet<Integer>> cols2 = new ArrayList<HashSet<Integer>>();
                List<HashSet<Integer>> boxes2 =       
                rows.get(i).add(x);
                cols.get(j).add(x);
                boxes.get(ij).add(x);
            }
        }
        return false;
    }

    
    boolean canBePut(List<HashSet<Integer>> sets, int index, int d) {
        if (sets.get(index).contains(d)) {
            return false;
        }
        sets.get(index).add(d);
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] board = {
            {"5","3",".",".","7",".",".",".","."}
           ,{"6",".",".","1","9","5",".",".","."}
           ,{".","9","8",".",".",".",".","6","."}
           ,{"8",".",".",".","6",".",".",".","3"}
           ,{"4",".",".","8",".","3",".",".","1"}
           ,{"7",".",".",".","2",".",".",".","6"}
           ,{".","6",".",".",".",".","2","8","."}
           ,{".",".",".","4","1","9",".",".","5"}
           ,{".",".",".",".","8",".",".","7","9"}
                   };
        char[][] bo = getCharBoard(board);
        s.solveSudoku(bo);
    }

    static char[][] getCharBoard(String[][] board) {
        char[][] bo = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) { 
                bo[i][j] = board[i][j].charAt(0);
            }
        }
        return bo;
    }
}