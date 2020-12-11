import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                try {
                    char d = stack.peek();
                    if ((c == ')' && d != '(') || (c == '}' && d != '{') || (c == ']' && d != '[')) {
                        return false;
                    } else {
                        stack.pop();
                    }
                } catch (EmptyStackException e) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.isValid("[[]]["));
    }
}