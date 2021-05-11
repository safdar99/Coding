import java.util.*;

//ITERATIVE SOLN
class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < 4 && i < s.length()-2; i++) 
            for (int j = i+1; j < i+4 && j < s.length()-1; j++)
                for (int k = j+1; k < j+4 && k < s.length(); k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        ans.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
        return ans;
    }

    public boolean isValid(String s) {
        if (s.isEmpty() || s.length() > 3 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.restoreIpAddresses("0279245587303"));
    }
}


//RECURSIVE SOLN
// class Solution {
// static void po(Object... o) {
// System.out.println(Arrays.deepToString(o));
// }

// public List<String> restoreIpAddresses(String s) {
// List<String> ans = new ArrayList<>();
// helper(s, new ArrayList(), ans, "");
// return ans;
// }

// void helper(String s, List<Integer> seq, List<String> ans, String pad) {
// // po(pad, s, seq);
// if (seq.size() == 4 || s.isEmpty()) {
// if (seq.size() == 4 && s.isEmpty()) {
// // po(pad, "adding", seq);
// StringBuilder ip = new StringBuilder();
// ip.append(seq.get(0));
// ip.append('.');
// ip.append(seq.get(1));
// ip.append('.');
// ip.append(seq.get(2));
// ip.append('.');
// ip.append(seq.get(3));
// // String ip = seq.get(0) + "." + seq.get(1) + "." + seq.get(2) + "." +
// // seq.get(3);
// ans.add(ip.toString());
// }
// return;
// }
// for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) {
// int no = Integer.parseInt(s.substring(0, i));
// if (no <= 255) {
// seq.add(no);
// helper(s.substring(i, s.length()), seq, ans, pad + " ");
// seq.remove(seq.size() - 1);
// }
// }
// }

// public static void main(String[] args) {
// Solution s = new Solution();
// po(s.restoreIpAddresses("101023"));
// }
// }

// // 101023
