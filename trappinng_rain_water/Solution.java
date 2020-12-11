import java.util.Arrays;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int trap(int[] arr) {
        int ans = 0;
        int size = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if ((i == 0 && i < size - 1 && x > arr[i + 1]) || (i > 0 && i < size - 1 && arr[i - 1] < x && x > arr[i + 1])) {
                int p = i;
                int j = i + 1;
                while (j < size) {
                    int y = arr[j];
                    if ((j < size - 1 && arr[j - 1] < y && y > arr[j + 1]) || (j == size - 1 && arr[j - 1] < y)) {
                        int q = j;
                        po(p,q);
                        int minH = Math.min(x, y);
                        int dist = q - p - 1;
                        int area = dist * minH;
                        p++;
                        while (p < q) {
                            area -= arr[p++];
                        }
                        ans += area;
                        i = q - 1;
                        break;
                    }
                    j++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = {4,2,0,3,2,5};
        po(s.trap(height));
    }
}