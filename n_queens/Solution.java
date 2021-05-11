import java.util.*;

class Solution {

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
    List<List<StringBuilder>> boards;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        boards = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        String boardRow = "";
        for (int i = 0; i < n; i++) boardRow += ".";
        utils(new ArrayList<>(), 0, boardRow, "");
        for (List<StringBuilder> board: boards) {
            List<String> boardString = new ArrayList<>();
            for (StringBuilder s: board) {
                boardString.add(s.toString());
            }
            ans.add(boardString);
        }
        printMat(ans);
        return ans;
    }

    void utils(ArrayList<StringBuilder> list, int row, String boardRow, String pad) {
        po(pad, row, list);
        if (!isValid(list)) return;
        if (row == n) {
            boards.add(list);
        }
        for (int c = 0; c < n; c++) {
            ArrayList<StringBuilder> list2 = (ArrayList<StringBuilder>) list.clone();
            StringBuilder boardRow2 = new StringBuilder(boardRow);
            boardRow2.setCharAt(c, 'Q');
            list2.add(boardRow2);
            utils(list2, row+1, boardRow, pad + "    ");
        }
    }
    boolean isValid(List<StringBuilder> b) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < b.size(); i++) {
            for (int j = 0; j < b.get(0).length(); j++) {
                if (b.get(i).charAt(j) == '.') continue;
                if (map.containsKey(j)) return false;
                for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                    int c = entry.getKey();
                    int r = entry.getValue();
                    if (Math.abs(j-c) == Math.abs(i-r)) return false;
                }
                map.put(j, i);
            }
        }
        return true;
    }

    void printMat(List<List<String>> mat) {
        for (List<String> s: mat) {
            po("====================================");
            for (String x: s) {
                po(x);
            }
            po("====================================");
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.solveNQueens(1));
    }
}