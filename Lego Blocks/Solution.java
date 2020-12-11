import java.io.*;
import java.util.*;

public class Solution {

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    static int N;   //Height of wall
    static int M;   //Width of wall
    static int mod = (int)1e9 + 7;
    static long[] noOfRows;  //number of rows of width i and height 1 formed by lego blocks
    static long[] unsolidWalls;  //number of unsolidWalls of width i and height N formed by lego blocks
    static long[] solidWalls;    //number of solidWalls of wdith i and height N formed by lego blocks

    static int legoBlocks(int n, int m) {
        N = n;
        M = m;
        noOfRows = new long[m+1];
        unsolidWalls = new long[m+1];
        solidWalls = new long[m+1];
        for (int i = 0; i < noOfRows.length; i++) {
            noOfRows[i] = -1;
            solidWalls[i] = -1;
        }
        getNumberOfRows(m);
        getNumberOfUnsolidWalls();
        getNumberOfSoldWalls(m);
        return (int)solidWalls[m];
    }

    static long getNumberOfRows(int width) {
        if (width < 0) {    //BASE CASE: 1
            return 0;
        } else if (width <= 1) {    //BASE CASE: 2
            noOfRows[width] = 1;

        } else if (noOfRows[width] == -1) {
            noOfRows[width] = (int) ((getNumberOfRows(width-1)%mod + 
            getNumberOfRows(width-2)%mod + 
            getNumberOfRows(width-3)%mod + 
            getNumberOfRows(width-4)%mod)
             % mod);
        }
        return noOfRows[width];
    }

    static void getNumberOfUnsolidWalls() {
        for (int i = 0; i < unsolidWalls.length; i++) {
            unsolidWalls[i] = pow(noOfRows[i], N);
        }
    }

    static long pow(long x, int y) {
        long ans = 1;
        while(y > 0) {
            if (y % 2 == 1) ans = ans * x % mod;
            x = x * x % mod;
            y /= 2;
        }
        return ans;
    }

    static long getNumberOfSoldWalls(int width) {
        if (solidWalls[width] == -1) {
            if (width == 1) {   //BASE CASE
                solidWalls[width] = 1;
            }
            solidWalls[width] = unsolidWalls[width];
            for (int cut = 1; cut < width; cut++) {
                long tmp = (getNumberOfSoldWalls(cut) * unsolidWalls[width-cut]) % mod;
                tmp = mod - tmp;
                solidWalls[width] = (solidWalls[width] + tmp) % mod;
            }
        }
        return solidWalls[width];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0].trim());

            int m = Integer.parseInt(nm[1].trim());

            int result = legoBlocks(n, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}