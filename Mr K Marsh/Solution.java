import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {


    static void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    static char mat[][];
    static int left[][];
    static int up[][];
    static int r, c;
    static int maxPeri = 0;

    static void formatGrid(String[] grid) {
        mat = new char[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            mat[i] = grid[i].toCharArray();
        }
        r = mat.length;
        c = mat[0].length;
    }

    static void calcLeft() {
        left = new int[r][c];
        for (int i = 0; i < r; i++) {
            left[i][0] = (mat[i][0] == '.' ? 0 : -1);
            for (int j = 1; j < c; j++) {
                if (mat[i][j] == '.') {
                    left[i][j] = left[i][j-1] + 1;
                } else {
                    left[i][j] = -1;
                }
            }
        }
    }

    static void calcUp() {
        up = new int[r][c];
        for (int j = 0; j < c; j++) {
            up[0][j] = (mat[0][j] == '.' ? 0 : -1);
            for (int i = 1; i < r; i++) {
                if (mat[i][j] == '.') {
                    up[i][j] = up[i-1][j] + 1;
                } else {
                    up[i][j] = -1;
                }
            }
        }   
    }

    static void kMarsh(String[] grid) {
        formatGrid(grid);
        calcLeft();
        calcUp();

        ArrayList<Integer> cols;
        for (int r1 = 0; r1 < r; r1++) {
            for (int r2 = r1+1; r2 < r; r2++) {
                int breadth = r2-r1;
                cols = new ArrayList<>();
                for (int j = 0; j < c; j++) {
                    if (up[r2][j] >= breadth) {
                        cols.add(j);
                    }
                }
                int i = 0, j = 0;
                while (j < cols.size() && i < cols.size()) {
                    int c1 = cols.get(i);
                    int c2 = cols.get(j);
                    if (i == j || rectPossible(r1, r2, c1, c2)) {
                        j++;
                    } else {
                        i++;
                    }
                }
            }
        }
        System.out.println(maxPeri > 0 ? maxPeri : "impossible");
    }

    static boolean rectPossible(int r1, int r2, int c1, int c2) {
        int breadth = r2-r1;
        int length = c2-c1;
        if (left[r1][c2] >= length && left[r2][c2] >= length) {
            int currPeri = 2*(length + breadth);
            // tr("    ", c1, c2, length, breadth, currPeri);
            maxPeri = Math.max(maxPeri, currPeri);
            return true;
        } else {
            // tr("    not possible", c1, c2);
            return false;
        }
    }

    private static final Scanner scanner = new Scanner(InputBridge.getFileInputStream());

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0].trim());

        int n = Integer.parseInt(mn[1].trim());

        String[] grid = new String[m];

        for (int gridItr = 0; gridItr < m; gridItr++) {
            String gridItem = scanner.nextLine();
            grid[gridItr] = gridItem;
        }

        kMarsh(grid);
    }
}
