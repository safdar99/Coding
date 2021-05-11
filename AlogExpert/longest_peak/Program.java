package longest_peak;

class Program {
  public static int longestPeak(int[] a) {
    // Write your code here.
		int len = a.length;
		if (len < 3) return 0;
		int p1 = 0;
		int p2 = 1;
		int max = 0;
		while (p2 < len) {
			boolean isInc = false;
			int start = p1;
			while (p2 < len && a[p1] < a[p2]) {
				isInc = true;
				p1++;p2++;
			}
			boolean isDec = false;
			while (p2 < len && a[p1] > a[p2]) {
				isDec = true;
				p1++;p2++;
			}
			if (isInc && isDec) {
				max = Math.max(max, p2-start);
			}
			while (p2 < len && a[p1] == a[p2]) {
				p1++;p2++;
			}
		}
    return max;
  }
}
