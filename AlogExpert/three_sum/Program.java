package three_sum;

import java.util.*;

//O(n^2) time | O(n) space
class Program {
	
	static void po(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
	
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
		Arrays.sort(array);
    List<Integer[]> ans = new ArrayList<Integer[]>();
		for (int i = 0; i < array.length; i++) {
			int firstNo = array[i];
			int sumLeft = targetSum - firstNo;
			int start = i+1;
			int end = array.length-1;
			while (start < end) {
				int secondNo = array[start];
				int thirdNo = array[end];
				int curSum = secondNo + thirdNo;
				if (curSum == sumLeft) {
					ans.add(new Integer[]{firstNo, secondNo, thirdNo});
					start++;
					end--;
				} else if (curSum < sumLeft) {
					start++;
				} else {
					end--;
				}
			}
		}
		return ans;
  }
}
