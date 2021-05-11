import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public int maximalRectangle(char[][] matrix) {
        int[] arr = new int[matrix[0].length];
        int maxArea = -1;
        for (char[] carr: matrix) {
            for (int i = 0; i < carr.length; i++) {
                if (carr[i] == '0') arr[i] = 0;
                else arr[i]++;
            }
            maxArea = Math.max(maxArea, getMaxArea(arr));
        }
        return maxArea;
    }
    
    int getMaxArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int maxArea = -1;
        int i;
        for (i = 0; i < arr.length; i++) {
            if (st.empty() || arr[st.peek()] <= arr[i]) st.push(i);
            else {
                while (!st.empty() && arr[st.peek()] > arr[i]) {
                    int j = st.pop();
                    int right = i-1;
                    int left = st.empty() ? -1 : st.peek();
                    int area = arr[j] * (right-left);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        while(!st.empty()) {
            int j = st.pop();
            int right = i-1;
            int left = st.empty() ? -1 : st.peek();
            int area = arr[j] * (right-left);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.maximalRectangle(new char[][] {

        }));
    }
}