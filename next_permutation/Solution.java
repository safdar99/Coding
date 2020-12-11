import java.util.Arrays;
import java.util.Collections;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public void nextPermutation(int[] a) {
        int index = -1;
        int n = a.length;
        for (int i = n-1; i > 0; i--) {
            if (a[i-1] < a[i]) {
                index = i-1;
                break;
            }
        }
        if (index == -1) {
            reverse(a, 0, n-1);
            return;
        }
        int val = a[index];
        int replaceIndex = bs(a, index+1, n-1, val);
        if (replaceIndex == -1) {
            reverse(a, 0, n-1);
            return;
        }
        po(index, val, replaceIndex);
        swap(a, index, replaceIndex);
        reverse(a, index+1, n-1);
    }

    int bs(int[] a, int s, int e, int val) {
        int ans = -1;
        while (s <= e) {
            int mid = (s+e)/2;
            if (a[mid] > val) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    void reverse(int[] a, int s, int e) {
        while (s < e) {
            swap(a, s, e);
            s++;
            e--;
        }
    }

    void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static void main(String[] args) {
        po("===========================================================================================================================================================");
        Solution s = new Solution();
        int[] nums = {2,2,7,5,4,3,2,2,1};
        po(nums);
        s.nextPermutation(nums);
        po(nums);
    }
}