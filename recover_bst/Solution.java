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
//MORRIS INORDER TRAVERSAL USING CONST SPACE (1)
class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
    
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode a = null, b = null;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode predecessor = findPredecessor(cur);
                if (predecessor.right == null) {//visiting first time
                    predecessor.right = cur;    //saving the cur node before its lost
                    cur = cur.left;
                } else if (predecessor.right == cur) { //already visited
                    predecessor.right = null;   //recovers the original structure
                    if (prev != null && prev.val > cur.val) {
                        a = a == null ? prev : a;
                        b = cur;
                    }
                    prev = cur;
                    cur = cur.right;
                }   
            } else {
                if (prev != null && prev.val > cur.val) {
                    a = a == null ? prev : a;
                    b = cur;
                }
                prev = cur;
                cur = cur.right;
            }
        }
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
    
    TreeNode findPredecessor(TreeNode node) {
        TreeNode tmp = node.left;
        while (tmp.right != null && tmp.right != node) {
            tmp = tmp.right;
        }
        return tmp;
    }
}


//INORDER TRAVESAL SOLN
// class Solution {
//     public void recoverTree(TreeNode root) {
//         Stack<TreeNode> st = new Stack();
//         TreeNode cur = root;
//         TreeNode prev = null;
//         TreeNode a = null, b = null;
//         while (cur != null || !st.isEmpty()) {
//             while (cur != null) {
//                 st.push(cur);
//                 cur = cur.left;
//             }
//             cur = st.pop();
//             if (prev != null && prev.val > cur.val) {
//                 if (a == null) {
//                     a = prev;
//                     b = cur;
//                 } else {
//                     b = cur;
//                 }
//             }
//             prev = cur;
//             cur = cur.right;
//         }
//         int tmp = a.val;
//         a.val = b.val;
//         b.val = tmp;
//     }
// }