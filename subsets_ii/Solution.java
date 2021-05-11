import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return dfs(new ArrayList<>(), nums, 0, new ArrayList<>());
    }
    
    public List<List<Integer>> dfs(List<List<Integer>> ans, int[] nums, int start, List<Integer> set) {
        ans.add(new ArrayList<Integer>(set));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            set.add(nums[i]);
            dfs(ans, nums, i+1, set);
            set.remove(set.size()-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.subsetsWithDup(new int[]{1,2,2}));
    }
}