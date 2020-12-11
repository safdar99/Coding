import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new LinkedList<>();
        generate(new StringBuilder(), '(', new Stack<Character>(), 0, n);
        return ans;
    }

    void generate(StringBuilder s, char p, Stack<Character> stack, int openP, int limit) {
        if (p == '(' && openP < limit) {
            s.append(p);
            stack.push(p);
            openP++;
        } else if (p == ')' && !stack.isEmpty() && stack.peek() == '(') {
            s.append(p);
            stack.pop();
        } else {
            return;
        }
        if (s.length() == 2*limit) {
            ans.add(s.toString());
            return;
        }
        generate(new StringBuilder(s), '(', (Stack<Character>) stack.clone(), openP, limit);
        generate(new StringBuilder(s), ')', (Stack<Character>) stack.clone(), openP, limit);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.generateParenthesis(3));
    }
}