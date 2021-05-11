package balanced_binary_tree;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    // Write your code here.
		return getBalancedHeight(tree) != -1;
	}
	
	int getBalancedHeight(BinaryTree root) {
		if (root == null) return 0;
		int leftH = getBalancedHeight(root.left);
		if (leftH == -1) return -1;
		int rightH = getBalancedHeight(root.right);
		if (rightH == -1) return -1;
		if (Math.abs(leftH-rightH) <= 1) {
			return 1 + Math.max(leftH, rightH);
		}
		return -1;
	}
	
}
