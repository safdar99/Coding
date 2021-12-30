import java.util.*;

//USING HEAPS
class Program {
	static void po(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}

  public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
    // Write your code here.
		if (times.size() == 0) return 0;
		Collections.sort(times, new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				if (a.get(0) != b.get(0)) return a.get(0) - b.get(0);
				return a.get(1) - b.get(1);
			}
		});
		PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>(times.size(), new Comparator<List<Integer>>() {
			public int compare(List<Integer> a, List<Integer> b) {
				return a.get(1) - b.get(1);
			}
		});
		pq.add(times.get(0));
		for (int i = 1; i < times.size(); i++) {
			List<Integer> min = pq.peek();
			List<Integer> cur = times.get(i);
			if (cur.get(0) >= min.get(1)) {
				pq.poll();
			} 
			pq.add(cur);
		}
    return pq.size();
    }
}

//USING SEPARATE START AND TIME ARRAYS 

class Program1 {

  public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
		List<Integer> starts = new ArrayList<Integer>();
		List<Integer> ends = new ArrayList<Integer>();
		for(List<Integer> time: times) {
			starts.add(time.get(0));
			ends.add(time.get(1));
		}
		Collections.sort(starts);
		Collections.sort(ends);
		int j = 0;
		int ans = 0;
		for(int i = 0; i < starts.size(); i++) {
			if (starts.get(i) >= ends.get(j)) j++;
			else ans++;
		}
    return ans;
  }
}
