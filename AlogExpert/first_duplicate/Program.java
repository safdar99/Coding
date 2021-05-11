package first_duplicate;

class Program {

  public int firstDuplicateValue(int[] array) {
    // Write your code here.
		for (int i = 0; i < array.length; i++) {
			int originalNo = Math.abs(array[i]);
			if (array[originalNo-1] < 0) return originalNo;
			array[originalNo-1] *= -1;
		}
    return -1;
  }
}
