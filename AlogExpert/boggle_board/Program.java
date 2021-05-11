package boggle_board;

import java.util.*;

class Program {
	static int rows;
	static int cols;
	static void po(Object... o) {System.out.println(Arrays.deepToString(o));}
  public static List<String> boggleBoard(char[][] board, String[] words) {
    // Write your code here.
		rows = board.length;
		cols = board[0].length;
 	 	ArrayList<String> ans = new ArrayList<String>();
		boolean[][] visited = new boolean[rows][cols];
		for (String word: words) {
			for (int i = 0; i < rows; i++) {
				boolean wordFound = false;
				for (int j = 0; j < cols; j++) {
					if (searchWord(word, board, i, j, visited)) {
						ans.add(word);
						wordFound = true;
						break;
					}
				}
				if (wordFound) break;
			}
		}
    return ans;
  }
	
	public static boolean searchWord(String word, char[][] board, int i, int j,boolean[][] visited) {
		if (word.isEmpty()) return true;
		if (i < 0 || i >= rows ||
				j < 0 || j >= cols ||
				visited[i][j] ||
				word.charAt(0) != board[i][j]) return false;
		visited[i][j] = true;
		boolean contains;
		contains = searchWord(word.substring(1), board, i-1, j, visited); //top
		if (contains) { visited[i][j] = false; return true; }
		contains = searchWord(word.substring(1), board, i-1, j+1, visited); //top-right
		if (contains) { visited[i][j] = false; return true; }
		contains = searchWord(word.substring(1), board, i, j+1, visited); //right
		if (contains) { visited[i][j] = false; return true; }
		contains = searchWord(word.substring(1), board, i+1, j+1, visited); //bottom-right
		if (contains) { visited[i][j] = false; return true; }
		contains = searchWord(word.substring(1), board, i+1, j, visited); //bottom
		if (contains) { visited[i][j] = false; return true; }
		contains = searchWord(word.substring(1), board, i+1, j-1, visited); //bottom-left
		if (contains) { visited[i][j] = false; return true; }
		contains = searchWord(word.substring(1), board, i, j-1, visited); //left
		if (contains) { visited[i][j] = false; return true; }
		contains = searchWord(word.substring(1), board, i-1, j-1, visited); //top-left
		if (contains) { visited[i][j] = false; return true; }
		visited[i][j] = false;
		return false;
	}
}
