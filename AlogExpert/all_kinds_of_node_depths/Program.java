package all_kinds_of_node_depths;

import java.util.*;

//O(n) time | O(d) space
class Program {
  static int ans;
	static void po(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
	
	public static int allKindsOfNodeDepths(BinaryTree root) {
    // Write your code here.
		ans = 0;
		helper(root);
    return ans;
  }

	static NodeInfo helper(BinaryTree node) {
		if (node == null) return new NodeInfo(0, 0);
		NodeInfo leftInfo = helper(node.left);
		NodeInfo rightInfo = helper(node.right);
		int depthSum = (leftInfo.depthSum + leftInfo.nodes) + 
										(rightInfo.depthSum + rightInfo.nodes);
		ans += depthSum;
		return new NodeInfo(depthSum, leftInfo.nodes + rightInfo.nodes + 1);		
	}
	
	static class NodeInfo {
		int nodes;
		int depthSum;
		
		NodeInfo(int depthSum, int nodes) {
			this.nodes = nodes;
			this.depthSum = depthSum;
		}
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

//O(n) time | O(h) space
// class Program {
//     public static int allKindsOfNodeDepths(BinaryTree root) {
//       // Write your code here.
//       return helper(root, 0);
//     }
      
//       static int helper(BinaryTree node, int depth) {
//           if (node == null) return 0;
          
//           int contri = (depth*(depth+1))/2;
//           return contri + helper(node.left, depth+1)
//                                       + helper(node.right, depth+1);
//       }
  
//     static class BinaryTree {
//       int value;
//       BinaryTree left;
//       BinaryTree right;
  
//       public BinaryTree(int value) {
//         this.value = value;
//         left = null;
//         right = null;
//       }
//     }
//   }
  

//O(nlongn) time | O(h) space
//worst O(n2) time | o(n) space
// class Program {
//   static void po(Object... o) {
// 		System.out.println(Arrays.deepToString(o));
// 	}
	
// 	public static int allKindsOfNodeDepths(BinaryTree root) {
//     // Write your code here.
// 		if (root == null) return 0;
// 		int ans = 0;
// 		Queue<BinaryTree> q = new LinkedList<>();
// 		q.add(root);
// 		while(!q.isEmpty()) {
// 			BinaryTree node = q.poll();
// 			if (node.left != null) q.add(node.left);
// 			if (node.right != null) q.add(node.right);
// 			int s = sumAllDepths(node);
// 			ans += s;
// 		}
// 		return ans;
//   }

// 	static int sumAllDepths(BinaryTree node) {
// 		int sum = 0;
// 		Queue<TreeInfo> q = new LinkedList<>();
// 		addChildsOf(new TreeInfo(node, 0), q);
// 		while (!q.isEmpty()) {
// 			TreeInfo info = q.poll();
// 			addChildsOf(info, q);
// 			sum += info.lvl;
// 		}
// 		return sum;
// 	}
	
// 	static void addChildsOf(TreeInfo info, Queue<TreeInfo> q) {
// 		BinaryTree node = info.node;
// 		if (node.left != null) q.add(new TreeInfo(node.left, info.lvl+1));
// 		if (node.right != null) q.add(new TreeInfo(node.right, info.lvl+1));
// 	}
	
// 	static class TreeInfo {
// 		BinaryTree node;
// 		int lvl;
// 		TreeInfo(BinaryTree node, int lvl) {
// 			this.node = node;
// 			this.lvl = lvl;
// 		}
// 	}
//   static class BinaryTree {
//     int value;
//     BinaryTree left;
//     BinaryTree right;

//     public BinaryTree(int value) {
//       this.value = value;
//       left = null;
//       right = null;
//     }
//   }
// }
