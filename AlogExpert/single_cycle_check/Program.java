package single_cycle_check;

import java.util.*;

//O(n) time | O(1) space
class Program {
	static void po(Object... o) {System.out.println(Arrays.deepToString(o));}
  public static boolean hasSingleCycle(int[] array) {
    // Write your code here.
		int len = array.length;
		if (len == 0) return false;
		if (len == 1) return true;
		int dest = (array[0]) % len;
		dest = dest >= 0 ? dest : dest + len;
		int count = 1;
		while (dest != 0 && count != len) {
			count++;
			dest = (dest + array[dest]) % len;
			dest = dest >= 0 ? dest : dest + len;
		}
		return dest == 0 && count == len;
  }
}
