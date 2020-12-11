import java.util.*;

class Solution {

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int a = nums[i];
            int j = i + 1;
            int k = nums.length-1;
            while (j < k) {
                int b = nums[j];
                int c = nums[k];
                int sum = a + b + c;
                if (target - sum == 0) return sum;
                if (diff > Math.abs(target - sum)) {
                    diff = Math.abs(target - sum);
                    ans = sum;
                } 
                if (sum < target) {
                    j++;
                    while(j < k && nums[j] == nums[j-1]) j++;
                } else {
                    k--;
                    while(k > j && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 1, -1, -1, 3};
        int target = 1;
        po(s.threeSumClosest(nums, target));
    }
}