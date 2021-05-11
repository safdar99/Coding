package appartment_hunting;

import java.util.*;

//O(br) time | O(br) space
class Program {
	static void po(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
  public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
    // Write your code here.
		HashMap<String, int[]> reqMap = new HashMap<>();
		for (String req: reqs) {
			int[] reqDists = new int[blocks.size()];
			Arrays.fill(reqDists, -1);
			reqMap.put(req, reqDists);
			int lastBlockHavingReq = -1;
			if (blocks.get(0).get(req)) {
				reqDists[0] = 0;
				lastBlockHavingReq = 0;
			}
			for (int j = 1; j < blocks.size(); j++) {
				Map<String, Boolean> block = blocks.get(j);
				if (block.get(req)) {
					reqDists[j] = 0;
					lastBlockHavingReq = j;
				} else if (lastBlockHavingReq != -1){
					int dist = Math.abs(j - lastBlockHavingReq);
					reqDists[j] = dist;
				}
			}
			lastBlockHavingReq = -1;
			if (blocks.get(blocks.size()-1).get(req)) {
				reqDists[blocks.size()-1] = 0;
				lastBlockHavingReq = blocks.size()-1;
			}
			for (int j = blocks.size()-2; j > -1; j--) {
				Map<String, Boolean> block = blocks.get(j);
				if (block.get(req)) {
					reqDists[j] = 0;
					lastBlockHavingReq = j;
				} else if (lastBlockHavingReq != -1) {
					int dist = Math.abs(lastBlockHavingReq - j);
					reqDists[j] = reqDists[j] == -1 ?  dist : Math.min(dist, reqDists[j]);
				}
			}
		}
		int ans = -1;
		int minFarthestDist = Integer.MAX_VALUE;
		for (int i = 0; i < blocks.size(); i++) {
			int curFarthestDist = Integer.MIN_VALUE;
			for (String req: reqs) {
				curFarthestDist = Math.max(curFarthestDist, reqMap.get(req)[i]);
			}
			if (curFarthestDist < minFarthestDist) {
				minFarthestDist = curFarthestDist;
				ans = i;
			}
		}
    return ans;
  }
}


//O(brlogb) time | O(br) space
// class Program {
//     static void po(Object... o) {
//         System.out.println(Arrays.deepToString(o));
//     }

//     public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
//         // Write your code here.
//         Map<String, List<Integer>> reqMap = new HashMap<>();
//         for (String req : reqs) {
//             reqMap.put(req, new ArrayList<>());
//         }
//         int i = 0;
//         for (Map<String, Boolean> block : blocks) {
//             putInMap(reqMap, block, i++);
//         }
//         int ans = -1;
//         int farthestDist = Integer.MAX_VALUE;
//         i = 0;
//         for (Map<String, Boolean> block : blocks) {
//             int curFarthestDist = 0;
//             for (String req : reqs) {
//                 if (!block.get(req)) {
//                     int index = getClosestBlockWhichHave(req, reqMap, i);
//                     int dist = Math.abs(i - index);
//                     curFarthestDist = Math.max(curFarthestDist, dist);
//                 }
//             }
//             if (curFarthestDist < farthestDist) {
//                 farthestDist = curFarthestDist;
//                 ans = i;
//             }
//             i++;
//         }
//         return ans;
//     }

//     static int getClosestBlockWhichHave(String req, Map<String, List<Integer>> reqMap, int x) {
//         List<Integer> a = reqMap.get(req);
//         int s = 0;
//         int e = a.size() - 1;
//         while (Math.abs(s - e) > 1) {
//             int m = (s + e) / 2;
//             if (x > a.get(m)) {
//                 s = m;
//             } else {
//                 e = m;
//             }
//         }
//         if (Math.abs(x - a.get(s)) < Math.abs(x - a.get(e))) {
//             return a.get(s);
//         } else {
//             return a.get(e);
//         }
//     }

//     static void putInMap(Map<String, List<Integer>> reqMap, Map<String, Boolean> block, int index) {
//         for (String facility : block.keySet()) {
//             if (reqMap.containsKey(facility) && block.get(facility)) {
//                 reqMap.get(facility).add(index);
//             }
//         }
//     }
// }
