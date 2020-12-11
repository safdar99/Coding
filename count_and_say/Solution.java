import java.util.Arrays;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    int getInt(char c) {
        return c- 48;
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String no = countAndSay(n-1);
        return utility(no);
    }

    String utility(String no) {
        StringBuffer buffer = new StringBuffer();
        int count = 1;
        int cur = getInt(no.charAt(0));
        for (int i = 1; i < no.length(); i++) {
            int x = getInt(no.charAt(i));
            if (x == cur) {
                count++;
            } else {
                buffer.append(count);
                buffer.append(cur);
                cur = x;
                count = 1;
            }
        }
        buffer.append(count);
        buffer.append(cur);
        return buffer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ans = s.countAndSay(30);
        po(ans);    
    }
}