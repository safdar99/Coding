import java.util.*;

class Solution2 {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();    
        if (nums.length < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int a = nums[i];
            int j = i + 1;
            int k = nums.length-1;
            while (j < k) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    j++;
                    continue;
                }
                int b = nums[j];
                int c = nums[k];
                if (a + b + c == 0) {
                    ans.add(Arrays.asList(a, b, c));
                    while (j < k && nums[j] == nums[j+1]) j++;
                    while (k > j && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                } else if (a + b + c < 0) {
                    while (j < k && nums[j] == nums[j+1]) j++;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] a = {-1, -1, 0, 1, 2, -4};
        po(s.threeSum(a));


    }
}