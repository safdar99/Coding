import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        if (numRows == 0) return "";
        StringBuffer ans = new StringBuffer();
        int nC;             //number of Columns passed
        int hC = numRows;   //height of each Column
        int nD;             //number of diagonals passed
        int hD = numRows-2; //height of each diagonal
        int nE;             //number of elements passed
        int prevColIndex;   //index of the last column passed wrt a diagonal
        int diff;           //difference between prevColIndex and "j" of diagonal 
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (j % (numRows - 1) == 0) {
                    nC = j / (numRows - 1);
                     nD = nC;
                     nE = nC*hC + nD*hD + i;
                    if (nE < s.length()) {
                        ans.append(s.charAt(nE));
                    }
                } else {
                     diff = j % (numRows - 1);
                     prevColIndex = j - diff;
                    if (i + j == prevColIndex + (numRows - 1)) {
                         nC = prevColIndex / (numRows - 1) + 1;
                         nD = prevColIndex / (numRows - 1);
                         nE = nC*hC + nD*hD + diff - 1;
                        if (nE < s.length()) {
                            ans.append(s.charAt(nE));
                        }
                    }
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.convert("PAYPALISHIRING", 2));
    }
}