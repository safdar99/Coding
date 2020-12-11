import java.util.Arrays;

public class Solution2 {
    
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i >= 0 && nums[i+1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length-1;
            while (j > i && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }

    void reverse(int[] a, int s) {
        int i = s;
        int j = a.length-1;
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        po("===============================================================");
        Solution2 s = new Solution2();
        int a[] = {2,2,7,5,4,3,2,2,1};
        po(a);
        s.nextPermutation(a);
        po(a);
    }
}