package max_path_sum;

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

// O(n) time | O(h) space
class Solution {
    public int maxPathSum(TreeNode root) {
        return getMps(root).mps;
    }

    TreeInfo getMps(TreeNode root) {
        if (root == null)
            return new TreeInfo(Integer.MIN_VALUE, 0);
        TreeInfo leftInfo = getMps(root.left);
        TreeInfo rightInfo = getMps(root.right);

        int mpsSoFar = Math.max(leftInfo.mps, rightInfo.mps);
        int cpsThrRoot = root.val;
        cpsThrRoot = Math.max(cpsThrRoot + leftInfo.cps, cpsThrRoot);
        cpsThrRoot = Math.max(cpsThrRoot + rightInfo.cps, cpsThrRoot);

        int cpsAtRoot = Math.max(leftInfo.cps, rightInfo.cps);
        cpsAtRoot = Math.max(root.val + cpsAtRoot, root.val);

        mpsSoFar = Math.max(mpsSoFar, Math.max(cpsThrRoot, cpsAtRoot));
        return new TreeInfo(mpsSoFar, cpsAtRoot);
    }

    class TreeInfo {
        int mps;
        int cps;

        TreeInfo(int mps, int cps) {
            this.mps = mps;
            this.cps = cps;
        }
    }
}