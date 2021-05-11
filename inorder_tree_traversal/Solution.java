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
 
//ITERATIVE SOLN
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }
}

//RECURSIVE SOLN
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         if (root != null)
//             doTraversal(root, ans);
//         return ans;
//     }
    
//     void doTraversal(TreeNode node, List<Integer> ans) {
//         if (node.left != null) {
//             doTraversal(node.left, ans);
//         }
//         ans.add(node.val);
//         if (node.right != null) {
//             doTraversal(node.right, ans);
//         }
//     }
// }