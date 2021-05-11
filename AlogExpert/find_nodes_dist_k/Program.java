package find_nodes_dist_k;

import java.util.*;

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

  public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
    // Write your code here.
    ArrayList<Integer> ans = new ArrayList<Integer>();
		getSearchDepth(tree, target, k, ans);
		return ans;
  }
	
	int getSearchDepth(BinaryTree tree, int target, int k, ArrayList<Integer> ans) {
		if (tree == null) return -1;
		if (target == tree.value) {
			addNodesAtDepth(tree, k, ans);
			return k-1;
		}
		int depth = getSearchDepth(tree.left, target, k, ans);
		if (depth == 0) {
			ans.add(tree.value);
			return -1;
		} else if (depth > 0) {
			addNodesAtDepth(tree.right, depth-1, ans);
			return depth-1;
		} 
		depth = getSearchDepth(tree.right, target, k, ans);
		if (depth == 0) {
			ans.add(tree.value);
			return -1;
		} else if (depth > 0) {
			addNodesAtDepth(tree.left, depth-1, ans);
			return depth-1;
		}
		return -1;
	}
	
	void addNodesAtDepth(BinaryTree tree, int k, ArrayList<Integer> ans) {
		if (tree == null) return;
		Queue<TreeInfo> q = new LinkedList<>();
		q.add(new TreeInfo(tree, 0));
		while (!q.isEmpty()) {
			TreeInfo treeInfo = q.poll();
			if (treeInfo.lvl == k) {
				ans.add(treeInfo.tree.value);
				while (!q.isEmpty()) ans.add(q.poll().tree.value);
				return;
			}
			if (treeInfo.tree.left != null) q.add(new TreeInfo(treeInfo.tree.left, treeInfo.lvl+1));
			if (treeInfo.tree.right != null) q.add(new TreeInfo(treeInfo.tree.right, treeInfo.lvl+1));
		}
	}
	
	static class TreeInfo {
		BinaryTree tree;
		int lvl;
		TreeInfo(BinaryTree tree, int lvl) {
			this.tree = tree;
			this.lvl = lvl;
		}
	}
}
