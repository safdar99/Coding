import java.util.Arrays;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    int[] dpLeft;
    int[] dpRight;

    public int trap(int[] arr) {
        int ans = 0;
        dpLeft = new int[arr.length];
        dpRight = new int[arr.length];
        int h[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dpLeft[i] = -1;
            dpRight[i] = -1;
        }
        for (int i = 0; i < arr.length; i++) {
            int h1 = maxLeft(arr, i - 1);
            int h2 = maxRight(arr, i + 1);
            h[i] = Math.min(h1, h2) - arr[i];
            h[i] = h[i] > 0 ? h[i] : 0;
            ans += h[i];
        }
        return ans;
    }

    int maxLeft(int[] a, int i) {
        if (i < 0)
            return 0;
        else if (i == 0)
            return a[i];
        else if (dpLeft[i] != -1)
            return dpLeft[i];
        else {
            dpLeft[i] = Math.max(maxLeft(a, i - 1), a[i]);
            return dpLeft[i];
        }
    }

    int maxRight(int[] a, int i) {
        if (i == a.length)
            return 0;
        else if (i == a.length - 1)
            return a[i];
        else if (dpRight[i] != -1)
            return dpRight[i];
        else {
            dpRight[i] = Math.max(maxRight(a, i + 1), a[i]);
            return dpRight[i];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = {4, 2, 0, 3, 2, 5};
        po(s.trap(height));
    }
}