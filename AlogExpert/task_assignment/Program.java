package task_assignment;

import java.util.*;

//O(nlogn) time | O(n) space
class Program {

	static void po(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
  public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
    // Write your code here.
    int[][] data = new int[tasks.size()][2];
		for (int i = 0; i < tasks.size(); i++) {
			data[i][0] = i;
			data[i][1] = tasks.get(i);
		}
		Arrays.sort(data, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] > b[1] ? 1 : a[1] == b[1] ? 0 : -1;
			}
		});
		int task1Index = 0;
		int task2Index = tasks.size()-1;
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		while (task1Index < task2Index) {
			ans.add(
				new ArrayList<Integer>(
					List.of(
						data[task1Index][0],
						data[task2Index][0]
					)
				)
			);
			task1Index++;
			task2Index--;
		}
		return ans;
  }
}
// 1 3 5 3 1 4
// 1 1 3 3 5 4
// 0 4 1 3 2 5