package Node_depths;


class Program {

    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        return getDepths(root, 0);
    }

    static int getDepths(BinaryTree root, int level) {
        int depths = level;
        if (root.left != null) {
            depths += getDepths(root.left, level + 1);
        }
        if (root.right != null) {
            depths += getDepths(root.right, level + 1);
        }
        return depths;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
