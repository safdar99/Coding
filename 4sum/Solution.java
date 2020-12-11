import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int a = nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int b = nums[j];
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    int c = nums[k];
                    int d = nums[l];
                    int sum = a + b + c + d;
                    if (target == sum) {
                        ans.add(Arrays.asList(a, b, c, d));
                        k++;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        l--;
                        while (l > k && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 0,0,0,0};
        int target = 0;
        po(s.fourSum(nums, target));
    }
}