package largest_range;

import java.util.*;

//O(n) time | O(n) space
class Program {

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public static int[] largestRange(int[] nums) {
        // Write your code here.
        int[] ans = new int[2];
        HashMap<Integer, Boolean> visited = new HashMap<>();
        for (int x : nums) {
            visited.put(x, false);
        }
        int maxRange = 0;
        for (int x : nums) {
            if (!visited.get(x)) {
                visited.put(x, true);
                int start = x;
                int end = x;
                int curRange = 1;
                // keep on searching till we find increasing seq
                int cur = x + 1;
                while (visited.containsKey(cur)) {
                    visited.put(cur, true);
                    end = cur;
                    cur++;
                    curRange++;
                }
                cur = x - 1;
                while (visited.containsKey(cur)) {
                    visited.put(cur, true);
                    start = cur;
                    cur--;
                    curRange++;
                }
                if (curRange > maxRange) {
                    maxRange = curRange;
                    ans[0] = start;
                    ans[1] = end;
                }
            }
        }
        return ans;
    }
}


//O(nlogn) tme | O(1) space
// class Program {
// 	static void po(Object... o) {
// 		System.out.println(Arrays.deepToString(o));
// 	}
	
//   public static int[] largestRange(int[] array) {
//     // Write your code here.
// 		Arrays.sort(array);
// 		int len = array.length;
// 		if (len == 0) return new int[]{};
// 		int start = 0;
// 		int end = 0;
// 		int[] ans = new int[]{array[start], array[end]};
// 		int maxRange = 1;
// 		for (int i = 1; i < len; i++) {
// 			if (array[end] == array[i]) continue;
// 			if (array[end] == array[i]-1) {
// 				end = i;
// 			} else {
// 				int curRange = end - (start == 0 ? 1 : start) + 1;
// 				if (curRange > maxRange) {
// 					maxRange = curRange;
// 					ans[0] = array[start];
// 					ans[1] = array[end];
// 				}
// 				start = i;
// 				end = i;
// 			}
// 		}
// 		int curRange = end - (start == 0 ? 1 : start) + 1;
// 		if (curRange > maxRange) {
// 			maxRange = curRange;
// 			ans[0] = array[start];
// 			ans[1] = array[end];
// 		}
// 		po(curRange, maxRange, end, start);
//     return ans;
//   }
// }
