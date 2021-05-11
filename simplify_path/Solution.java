import java.util.*;
class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
    
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> stck = new Stack<>();
        for (String dir: dirs) {
            if (dir.equals(".") || dir.isEmpty()) {
                continue;
            }
            stck.push("/");
            if (dir.equals("..")) {
                if (stck.size() >= 3) {
                    stck.pop(); stck.pop(); stck.pop();
                } else {
                    stck.pop();
                }
            } else {
                stck.push(dir);
            }
            // po(stck);
        }
        StringBuilder ans = new StringBuilder();
        while (!stck.isEmpty()) {
            StringBuilder s = new StringBuilder(stck.pop());
            ans = s.append(ans);
        }
        if (ans.length() == 0) ans.append('/');
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.simplifyPath("/a/../../b/../c//.//"));
    }
}