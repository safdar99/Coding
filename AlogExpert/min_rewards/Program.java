package min_rewards;

import java.util.*;
//O(n) time | O(n) space
class Program {
  public static int minRewards(int[] scores) {
    // Write your code here.
		int len = scores.length;
		int[] rewards = new int[len];
		Arrays.fill(rewards, 1);
		for (int i = 1; i < len; i++) {
			if (scores[i-1] < scores[i]) {
				rewards[i] = rewards[i-1] + 1;
			}
		}
		for (int i = len-2; i > -1; i--) {
			if (scores[i] > scores[i+1]) {
				rewards[i] = Math.max(rewards[i], rewards[i+1] + 1);
			}
		}
		int ans = 0;
		for (int i = 0; i < len; i++) ans += rewards[i];
    return ans;
  }
}


//O(n) time | O(n) space
// class Program {
// 	static void po(Object... o) {
// 		System.out.println(Arrays.deepToString(o));
// 	}
	
//   public static int minRewards(int[] scores) {
//     // Write your code here.
// 		int[] lessNosToRight = new int[scores.length];
// 		int[] rewards = new int[scores.length];
// 		int len = scores.length;
// 		lessNosToRight[len-1] = 0;
// 		for (int i = len-2; i > -1; i--) {
// 			if (scores[i] > scores[i+1]) {
// 				lessNosToRight[i] = 1 + lessNosToRight[i+1];
// 			}
// 		}
// 		int prev = Integer.MIN_VALUE;
// 		int prevReward = 0;
// 		int ans = 0;
// 		for (int i = 0; i < len; i++) {
// 			int curReward;
// 			if (prev < scores[i]) {
// 				curReward = prevReward + 1;
// 				if (curReward <= lessNosToRight[i]) {
// 					curReward = lessNosToRight[i] + 1;
// 				}
// 			} else {
// 				curReward = lessNosToRight[i]+1;
// 			}
// 			rewards[i] = curReward;
// 			ans += curReward;
// 			prev = scores[i];
// 			prevReward = curReward;
// 		}
//     return ans;
//   }
// }
