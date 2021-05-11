import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public List<Integer> grayCode(int n) {
        int bits = (int)Math.pow(2, n);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < bits; i++) ans.add(0);
        for (int i = 0; i < bits/2; i++) {
            ans.set(i, i);
            ans.set(bits-i-1, i | (1<<n-1));
        }
        return ans;
    }

    List<Integer> getGrayCode(int n) {
        if (n == 1) return Arrays.asList(0,1);
        else {
            int bitMask = 1 << n-1;
            List<Integer> prevList = getGrayCode(n-1);
            List<Integer> list = new ArrayList<>(prevList);
            for (int i = prevList.size()-1; i > -1; i--) {
                int y = prevList.get(i) | bitMask;
                list.add(y);
            }
            return list;
        }
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.grayCode(4));
    }
}