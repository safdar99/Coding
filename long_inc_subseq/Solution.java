import java.util.*;

class Solution {
    // User function Template for Java
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int removeStudents(int[] h, int n) {
        // code here
        if (n < 2)
            return 0;
        int[] lens = new int[n + 1];
        Arrays.fill(lens, -1);
        int maxSeq = 1;
        lens[1] = 0;
        for (int i = 1; i < n; i++) {
            int start = 1;
            int end = maxSeq;
            boolean f = false;
            while (start < end) {
                int mid = (start + end) / 2;
                po(start, mid, end, h[i]);
                if (h[i] == h[lens[mid]]) {
                    lens[mid] = i;
                    f = true;
                    break;
                } else if (h[lens[mid]] < h[i]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            if (f)
                continue;
            if (h[lens[start]] < h[i]) {
                lens[start + 1] = i;
                maxSeq++;
            } else {
                lens[start] = i;
            }
        }
        return n - maxSeq;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.removeStudents(new int[]{0, 1, 2, 3, 4, 5}, 6));
    }
}