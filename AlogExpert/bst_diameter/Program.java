package bst_diameter;

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

  public int binaryTreeDiameter(BinaryTree tree) {
		return getMaxHeight(tree).diameter;
  }
	
	TreeInfo getMaxHeight(BinaryTree root) {
		if (root == null) return new TreeInfo(0, 0);
		TreeInfo leftInfo = getMaxHeight(root.left);
		TreeInfo rightInfo = getMaxHeight(root.right);
		
		int longestPathThrRoot = leftInfo.height + rightInfo.height;
		int maxDiaSoFar = Math.max(leftInfo.diameter, rightInfo.diameter);
		int maxDia = Math.max(longestPathThrRoot, maxDiaSoFar);
		int currentHeight = 1 + Math.max(leftInfo.height, rightInfo.height);
		return new TreeInfo(currentHeight, maxDia);
	}
	
	static class TreeInfo {
		int height;
		int diameter;
		
		public TreeInfo(int height, int dia) {
			this.height = height;
			this.diameter = dia;
		}
	}
}
