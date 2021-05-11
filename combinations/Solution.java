import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<List<Integer>>();
        for (int i = 1; i <= n-k+1; i++) {
            getAllArrays(i, n, 0, k, new ArrayList<Integer>());
        }
        return ans;
    }
    
    void getAllArrays(int x, int n, int size, int k, ArrayList<Integer> arr) {
        arr.add(x);
        size++;
        if (size == k) {
            ans.add(arr);
            return;
        }
        for (int i = x+1; i <= n-(k-size)+1; i++) {
            getAllArrays(i, n, size, k, (ArrayList<Integer>) arr.clone());
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.combine(5, 3));
    }
}
