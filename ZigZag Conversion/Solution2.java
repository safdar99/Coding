import java.util.Arrays;

class Solution2 {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    enum Direction {
        up, down;
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuffer[] store = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            store[i] = new StringBuffer();
        }
        Direction dir = Direction.down;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            store[row].append(s.charAt(i));
            po(row, s.charAt(i), dir);
            if (dir == Direction.up) {
                row--;
            } else {
                row++;
            }
            if (row == numRows-1) dir = Direction.up;
            else if (row == 0) dir = Direction.down;
        }
        StringBuffer ans = new StringBuffer();
        for (StringBuffer stringBuffer : store) {
            po(stringBuffer);
            ans.append(stringBuffer.toString());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        po(s.convert("PAYPALISHIRING", 4));
    }
}