import java.util.*;

class Solution {

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int removeDuplicates(int[] a) {
        if (a.length == 0) return 0;
        if (a.length == 1) return 1;

        int prev = a[0];
        int j = 1;
        for (int i = 1; i < a.length; i++) {
            int cur = a[i];
            if (prev == cur) continue;
            else {
                a[j++] = cur;
                prev = cur;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.removeDuplicates(new int[] {}));//,2,3,3,4}));    
    }

}