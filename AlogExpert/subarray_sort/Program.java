package subarray_sort;

//O(n) time | O(1) space
class Program {
    public static int[] subarraySort(int[] array) {
        // Write your code here.
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;
        int len = array.length;
        for (int i = 0; i < array.length; i++) {
            if (isOutOfOrder(array, i)) {
                minOutOfOrder = Math.min(minOutOfOrder, array[i]);
                maxOutOfOrder = Math.max(maxOutOfOrder, array[i]);
            }
        }
        if (minOutOfOrder == Integer.MAX_VALUE)
            return new int[] { -1, -1 };
        int left = 0;
        while (left < len && array[left] <= minOutOfOrder) {
            left++;
        }
        int right = len - 1;
        while (right > -1 && array[right] >= maxOutOfOrder) {
            right--;
        }
        return new int[] { left, right };
    }

    public static boolean isOutOfOrder(int[] a, int i) {
        if (i == 0) {
            return a[i] > a[i + 1];
        }
        if (i == a.length - 1) {
            return a[i] < a[i - 1];
        }
        return a[i] > a[i + 1] || a[i] < a[i - 1];
    }
}


//O(n) time | O(1) space using BINARY SEARCH
// class Program {
// 	static void po(Object... o) {
// 		System.out.println(Arrays.deepToString(o));
// 	}
	
//   public static int[] subarraySort(int[] a) {
//     // Write your code here.
// 		int len = a.length;
// 		int left = Integer.MIN_VALUE;
// 		int i = 0;
// 		while (i < len && left <= a[i]) {
// 			left = a[i];
// 			i++;
// 		}
// 		if (i == len) return new int[]{-1, -1};
// 		int leftSortedEnd = i-1;
// 		int min = a[i];
// 		while (i < len) {
// 			if (a[i] < min) min = a[i];
// 			i++;
// 		}
// 		int ansBegin = closestAndBigger(a, 0, leftSortedEnd, min);
// 		po(ansBegin);
// 		int right = Integer.MAX_VALUE;
// 		int j = len-1;
// 		while (j > -1 && a[j] <= right) {
// 			right = a[j];
// 			j--;
// 		}
// 		int rightSortedStart = j+1;
// 		int max = a[j];
// 		while (j >= leftSortedEnd) {
// 			if (max < a[j]) max = a[j];
// 			j--;
// 		}
// 		int ansEnd = closestAndLesser(a, rightSortedStart, len-1, max);
		
//     return new int[] {ansBegin, ansEnd};
//   }
	
// 	static int closestAndBigger(int[] a, int start, int end, int val) {
// 		po(val);
// 		while (start < end) {
// 			int mid = (start + end)/2;
// 			if (a[mid] <= val) {
// 				start = mid+1;
// 			} else {
// 				end = mid;
// 			} 
// 		}
// 		return end;
// 	}
	
// 	static int closestAndLesser(int[] a, int start, int end, int val) {
// 		po(val);
// 		while (start < end) {
// 			int mid = (start + end + 1)/2;
// 			po(start, mid, end);
// 			if (val <= a[mid]) {
// 				end = mid - 1;
// 			} else {
// 				start = mid;
// 			}
// 		}
// 		return start;
// 	}
// }
