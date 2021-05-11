package right_sibling_tree;

import java.util.*;

//O(n) time | O(d) space
class Program {
	static void po(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
	
  public static BinaryTree rightSiblingTree(BinaryTree root) {
    // Write your code here.
		if (root == null) return root;
		Queue<TreeInfo> q = new LinkedList<>();
		int depth = 0;
		q.add(new TreeInfo(root, 0));
		while (!q.isEmpty()) {
			TreeInfo curInfo = q.poll();
			addChildsOf(curInfo, q);
			BinaryTree curNode = curInfo.node;
			if (q.isEmpty()) break;
			TreeInfo nextInfo = q.peek();
			if (nextInfo.lvl == depth) {
				BinaryTree nextNode = nextInfo.node;
				if (curNode != null) curNode.right = nextNode;
			} else {
				if (curNode != null) curNode.right = null;
				depth++;
			}
		}
    return root;
  }
	
	static void addChildsOf(TreeInfo info, Queue<TreeInfo> q) {
		if (info.node == null) return;
		BinaryTree node = info.node;
		q.add(new TreeInfo(node.left, info.lvl+1));
		q.add(new TreeInfo(node.right, info.lvl+1));
	}

  // This is the class of the input root. Do not edit it.
  static class BinaryTree {
    int value;
    BinaryTree left = null;
    BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
	
	static class TreeInfo {
		BinaryTree node;
		int lvl;
		
		TreeInfo(BinaryTree node, int lvl) {
			this.node = node;
			this.lvl = lvl;
		}
	}
}

