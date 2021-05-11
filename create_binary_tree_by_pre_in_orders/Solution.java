import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


// RECURSIVE SOLUTION
// class Solution {
//     static void po(Object... o) {
//         System.out.println(Arrays.deepToString(o));
//     }

//     int[] pre, ino;
//     int preIndex;
//     HashMap<Integer, Integer> inoMap;
//     public TreeNode buildTree(int[] pre, int[] ino) {
//         if (pre.length == 0) return null;
//         this.pre = pre;
//         this.ino = ino;
//         this.preIndex = 1;
//         inoMap = new HashMap<>();
//         for (int i = 0; i < ino.length; i++) inoMap.put(ino[i], i);
//         TreeNode root = new TreeNode(pre[0]);
//         func(root, 0, pre.length-1);
//         return root;
//     }

//     public void func(TreeNode root, int l, int r) {
//         if (l == r) return;
//         if (preIndex == pre.length) return;
//         int nodeVal = pre[preIndex];
//         int m = inoMap.get(root.val);
//         int j = inoMap.get(nodeVal);
//         if (l <= j && j < m) {
//             root.left = new TreeNode(nodeVal);
//             preIndex++;
//             func(root.left, l, m-1);
//             if (preIndex == pre.length) return;
//             nodeVal = pre[preIndex];
//             j = inoMap.get(nodeVal);
//         }
//         if (m < j && j <= r) {
//             root.right = new TreeNode(nodeVal);
//             preIndex++;
//             func(root.right, m+1, r);
//         }
//     } 

//     public static void main(String[] args) {
//         Solution s = new Solution();
//         int[] pre = new int[]{3,2,1,4};
//         int[] ino = new int[]{1,2,3,4};
//         s.buildTree(pre, ino);
//     }
// }