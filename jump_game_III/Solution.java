import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public boolean canReach(int[] arr, int start) {
        Stack<Integer> q = new Stack<Integer>();
        boolean[] visited = new boolean[arr.length];
        q.add(start+arr[start]);
        q.add(start-arr[start]);
        while (!q.isEmpty()) {
            int jumpIndex = q.pop();
            if (jumpIndex > -1 && jumpIndex < arr.length && !visited[jumpIndex]) {
                if (arr[jumpIndex] == 0) return true;
                visited[jumpIndex] = true;
                q.add(jumpIndex+arr[jumpIndex]);
                q.add(jumpIndex-arr[jumpIndex]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.canReach(new int[]{3,0,2,1,2}, 2));
    }
}