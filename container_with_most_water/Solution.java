import java.util.Arrays;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    static int[][] dp;
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int i1 = 0, i2 = height.length-1;
        while (i1 <= i2) {
            int h1 = height[i1], h2 = height[i2];
            int area = Math.min(h1, h2) * (i2-i1);
            maxArea = Math.max(area, maxArea);
            if (h1 < h2) {
                i1++;
            } else {
                i2--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        po(s.maxArea(height));
    }
}