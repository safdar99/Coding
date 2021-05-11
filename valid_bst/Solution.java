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


//ITERATIVE SOLUTION USING STACK AND INORDER TRAVERSAL
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            if (prev != null && prev.val >= cur.val) {
                return false;
            } else {
                prev = cur;
            }
            cur = cur.right;
        }
        return true;
    }
}


// RECURSIVE SOLUTION 
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if (root == null) return true;
//         return isValidSubtree(root.left, Long.MIN_VALUE, root.val) 
//             && isValidSubtree(root.right, root.val, Long.MAX_VALUE);
//     }
    
//     boolean isValidSubtree(TreeNode root, long min, long max) {
//         if (root == null) return true;
//         if (root.val <= min || root.val >= max) return false;
//         return isValidSubtree(root.left, min, root.val)
//             && isValidSubtree(root.right, root.val, max);
//     }
// }
