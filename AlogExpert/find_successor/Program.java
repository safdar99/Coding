package find_successor;

//O(n) time | O(h) space
// class Program {
//   // This is an input class. Do not edit.
//   static class BinaryTree {
//     public int value;
//     public BinaryTree left = null;
//     public BinaryTree right = null;
//     public BinaryTree parent = null;

//     public BinaryTree(int value) {
//       this.value = value;
//     }
//   }

//   public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
//     // Write your code here.
// 		Stack<BinaryTree> st = new Stack<>();
// 		BinaryTree cur = tree;
// 		BinaryTree prev = null;
// 		while (!st.isEmpty() || cur != null) {
// 			while (cur != null) {
// 				st.push(cur);
// 				cur = cur.left;
// 			}
// 			cur = st.pop();
// 			if (prev == node) {
// 				return cur;
// 			}
// 			prev = cur;
// 			cur = cur.right;
// 		}
//     return null;
//   }
// }

//O(h) time | O(1) space
class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    // Write your code here.
		if(node.right != null) {
			return getLeftMostChild(node.right);
		}
    return getRightMostParent(node);
  }
	
	BinaryTree getLeftMostChild(BinaryTree node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	BinaryTree getRightMostParent(BinaryTree node) {
		while(node.parent != null && node.parent.right == node) {
			node = node.parent;
		}
		return node.parent;
	}
}
