package invert_bst;
// TIME COMPLEXITY O(N)
//****************** SPACE COMPLEXITY O(N) ****************** because of all the leaves that get stored in queue at last level
import java.util.*;
//ITERATIVE
class Program {
  public static void invertBinaryTree(BinaryTree tree) {
    // Write your code here.
		Stack<BinaryTree> st = new Stack<>();
		st.add(tree);
		while (!st.isEmpty()) {
			BinaryTree node = st.pop();
			BinaryTree left = node.left;
			node.left = node.right;
			node.right = left;
			if (node.left != null) {
				st.push(node.left);
			}
			if (node.right != null) {
				st.push(node.right);
			}
		}
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
