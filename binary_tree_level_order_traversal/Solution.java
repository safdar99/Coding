import java.util.*;
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  class Solution {
      static void po(Object... o) {
          System.out.println(Arrays.deepToString(o));
      }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        return ans;
    }

    public static void main(String[] args) {
        int h = 398123720;
        List<Integer> l = new ArrayList<>();
        if ((h & 1) == 0) {
            po("even");
        } else {
            po("odd");
        }
    }
}