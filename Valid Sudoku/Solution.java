import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public boolean isValidSudoku(String[][] c) {
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
                if (c[i][j] != ".") {
                    int d = c[i][j].charAt(0) - 48;
                    int ij = (i/3) * 3 + j/3;
                    po(i, j);
                    if (canBePut(rows, i, d) && canBePut(cols, j, d) && canBePut(boxes, ij, d)) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
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
 {"8","3",".",".","7",".",".",".","."}
,{"6",".",".","1","9","5",".",".","."}
,{".","9","8",".",".",".",".","6","."}
,{"8",".",".",".","6",".",".",".","3"}
,{"4",".",".","8",".","3",".",".","1"}
,{"7",".",".",".","2",".",".",".","6"}
,{".","6",".",".",".",".","2","8","."}
,{".",".",".","4","1","9",".",".","5"}
,{".",".",".",".","8",".",".","7","9"}
        };
        po(s.isValidSudoku(board));
    }
}