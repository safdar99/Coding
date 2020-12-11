import java.util.*;

class Solution {

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                int top = st.peek();
                char c = top == -1 ? ')': s.charAt(top);
                if (c == '(') {
                    st.pop();
                    top = st.peek();
                    int curLen = i - top;
                    ans = Math.max(ans, curLen);
                } else {
                    st.push(i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String in = ")()";
        po(s.longestValidParentheses(in));
    }
}