import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    List<List<Integer>> ans;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<List<Integer>>();
        ans.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> lists = new ArrayList<>();
            lists.add(new ArrayList<Integer>(Arrays.asList(nums[i])));
            for (List<Integer> arr: ans) {
                if (arr.isEmpty()) continue;
                List<Integer> arr2 = (List<Integer>)((ArrayList<Integer>) arr).clone();
                arr2.add(nums[i]);
                lists.add(arr2);
            }
            for (List<Integer> list: lists) {
                ans.add(list);
            }
        }
        int n = nums.length;
        int nthBit = 1 << n;
        for (int i = 0; i < (int)Math.pow(2, n); ++i) {
        // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i | nthBit);
            po(Integer.toBinaryString(i), Integer.toBinaryString(nthBit), bitmask.substring(1), bitmask);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.subsets(new int[] { 1, 2, 3, 4 }));
    }
}