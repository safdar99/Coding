package sorted_squares;

//O(n) time | O(n) space **1 for loop**
class Program {

  public int[] sortedSquaredArray(int[] array) {
    // Write your code here.
		int len = array.length;
		int[] ans = new int[len];
		int p1 = 0;
		int p2 = len-1;
		for (int i = len-1; i > -1; i--) {
			if (Math.abs(array[p1]) > Math.abs(array[p2])) {
				ans[i] = (int) Math.pow(array[p1++], 2);
			} else {
				ans[i] = (int) Math.pow(array[p2--], 2);
			}
		}
    return ans;
  }
}


//O(n) time | O(n) space **2 for loops**
// class Program {

//   public int[] sortedSquaredArray(int[] array) {
//     // Write your code here.
// 		int len = array.length;
// 		List<Integer> negSq = new ArrayList<>();
// 		List<Integer> posSq = new ArrayList<>();
// 		int[] ansSq = new int[len];
// 		int i;
// 		for (i = 0; i < len && array[i] < 0; i++) {
// 			negSq.add(array[i] * array[i]);
// 		}
// 		for (; i < len; i++) {
// 			posSq.add(array[i] * array[i]);
// 		}
// 		int p1 = negSq.size()-1, p2 = 0;
// 		int index = 0;
// 		while (p1 > -1 && p2 < posSq.size()) {
// 			if (negSq.get(p1) < posSq.get(p2)) {
// 				ansSq[index++] = negSq.get(p1--);
// 			} else {
// 				ansSq[index++] = posSq.get(p2++);
// 			}
// 		}
// 		while (p1 > -1) ansSq[index++] = negSq.get(p1--);
// 		while (p2 < posSq.size()) ansSq[index++] = posSq.get(p2++);
//     return ansSq;
//   }
// }
