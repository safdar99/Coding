import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	static class Point {
		int r;	//row
		int c;	//column
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public String toString() {
			return "(" + r + "," + c + ")";
		}
	}
	
	static void tr(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
	
	static int getInt(String s) {
		return Integer.parseInt(s);
	}

	static int[][] formMatrix(String[] input, int size) {
		int mat[][] = new int[size][size];
		int k = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				mat[i][j] = getInt(input[k++]);
			}
		}
		return mat;
	}

	static void swap(int[][] mat, Point p1, Point p2) {
		int k = mat[p1.r][p1.c];
		mat[p1.r][p1.c] = mat[p2.r][p2.c];
		mat[p2.r][p2.c] = k;
	}

	static void roatateMatrix(int[][] mat, int size, StringBuffer ans) {
		int i = 0;
		int j = 0;
		int x = size-1;
		while (i < size/2) {	
			int k = -1;
			while (k++ != x-1) {
				Point a = new Point(i, j+k);
				Point b = new Point(i+k, j+x);
				Point c = new Point(i+x-k, j);
				Point d = new Point(i+x, j+x-k);
				swap(mat, c, a);
				swap(mat, a, b);
				swap(mat, b, d);
			}
			i++;
			j++;
			x -= 2;
		}
		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				ans.append(mat[i][j]);
				ans.append(" ");
			}
			ans.append("\n");
		}
		ans.append("\n");
	}

	static void takeInputAndProcess() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(InputBridge.getFileInputStream()));
		int t = getInt(br.readLine());
		StringBuffer ans = new StringBuffer();
		while (t-- > 0) {
			int size = getInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[][] mat = formMatrix(input, size);
			roatateMatrix(mat, size, ans);
		}
		System.out.print(ans.toString());
	}

	public static void main (String[] args) throws IOException {
		takeInputAndProcess();
	}	
}