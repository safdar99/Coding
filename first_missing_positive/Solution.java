import java.util.Arrays;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int firstMissingPositive(int[] nums) {
        nums = separatePositive(nums);
        int i;
        for (i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i])-1;
            if (x >= 0) {
                if (x < nums.length && nums[x] > 0) { 
                    nums[x] = -nums[x];
                }
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) return i+1;
        }
        return i+ 1;
    }

    public int[] separatePositive(int[] nums) {
        po(nums);
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
        po(nums);
        int arr[] = new int[nums.length];
        int k = 0;
        for (int i = j; i < nums.length; i++) {
            if (nums[i] > 0) {
                arr[k++] = nums[i];
            } 
        }
        po(arr);
        return arr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {};
        po(s.firstMissingPositive(nums));
    }
}