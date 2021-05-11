package class_photograph;

import java.util.*;
//O(nlogn) time | O(1) space
class Program {

  public boolean classPhotos(
      ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
    // Write your code here.
		Collections.sort(redShirtHeights, Collections.reverseOrder());
		Collections.sort(blueShirtHeights, Collections.reverseOrder());
		
		char firstRow = redShirtHeights.get(0) < blueShirtHeights.get(0) ? 'R' : 'B';
		for (int i = 0; i < redShirtHeights.size(); i++) {
			if (firstRow == 'R') {
				if (redShirtHeights.get(i) >= blueShirtHeights.get(i)) return false;
			} else {
				if (redShirtHeights.get(i) <= blueShirtHeights.get(i)) return false;
			}
		}
    return true;
  }
}