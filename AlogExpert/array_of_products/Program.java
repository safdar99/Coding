package array_of_products;

// o(n) time | O(n) space
class Program {
  public int[] arrayOfProducts(int[] array) {
    // Write your code here.
		int len = array.length;
		int[] a = new int[len];
		int runLeftP = 1;
		for (int i = 0; i < len; i++) {
			a[i] = runLeftP;
			runLeftP *= array[i];
		}
		int runRightP = 1;
		for (int i = len-1; i >= 0; i--) {
			a[i] *= runRightP;
			runRightP *= array[i];
		}
    return a;
  }
}
