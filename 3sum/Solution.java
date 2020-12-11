import java.util.*;

class Solution {

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums.length == 0) return ans;
        int prev1 = nums[0]; 
        for (int i = 0; i < nums.length-1; i++) {
            int a = nums[i];
            if (i != 0 && a == prev1) continue;
            int prev2 = nums[i+1];
            for (int j = i+1; j < nums.length; j++) {
                int b = nums[j];
                if (j != i+1 && b == prev2) continue;
                int c = 0 - b - a;
                boolean f = false;
                if (i == 0 && j == 1) f = true; 
                if (binarySearch(nums, j+1, nums.length-1, c, f)) {
                    ans.add(Arrays.asList(a, b, c));
                }
                prev2 = b;
            }
            prev1 = nums[i];
        }
        return ans;
    }

    boolean binarySearch(int[] nums, int start, int end, int c, boolean f) {
        while (start <= end) {
            int mid = (start + end)/2;
            if (nums[mid] == c) return true;
            else if (nums[mid] < c) start = mid+1;
            else end = mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 0, 0, 0};
        po(s.threeSum(nums));
    }
}