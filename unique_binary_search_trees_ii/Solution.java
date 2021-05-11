import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
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
    public List<TreeNode> generateTrees(int n) {
        return createSubtrees(1, n);
    }

    List<TreeNode> createSubtrees(int first, int last) {
        List<TreeNode> trees = new ArrayList();
        if (first > last) {
            trees.add(null);
            return trees;
        }
        for (int root = first; root <= last; root++) {
            List<TreeNode> leftSubtrees = createSubtrees(first, root - 1);
            List<TreeNode> rightSubtrees = createSubtrees(root + 1, last);
            for (TreeNode leftSubtree : leftSubtrees) {
                for (TreeNode rightSubtree : rightSubtrees) {
                    trees.add(new TreeNode(root, leftSubtree, rightSubtree));
                }
            }
        }
        return trees;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.generateTrees(3);
    }
}
