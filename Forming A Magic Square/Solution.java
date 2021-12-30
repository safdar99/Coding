import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class Solution {

    static int count = 0;

    static void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
    static void permute(int[] a, int pos, int val) {
        func(new ArrayList<>(Arrays.asList(1, 2, 3, 4)), new ArrayList<Integer>());
    }

    static void func(ArrayList<Integer> a, ArrayList<Integer> currSet) {
        if (a.isEmpty()) {
            tr(a);
            return;
        }
        for (Integer x: a) {
            ArrayList<Integer> newList = (ArrayList<Integer>) a.clone();
            newList.remove(x);
            currSet.add(x);
            func(newList, currSet);
        }
    } 

    static boolean isMagicalMatrix(int[] a) {
        int rowSum1 = a[0] + a[1] + a[2];
        int rowSum2 = a[3] + a[4] + a[5]; 
        int rowSum3 = a[6] + a[7] + a[8]; 
        
        int colSum1 = a[0] + a[3] + a[6];
        int colSum2 = a[1] + a[4] + a[7];
        int colSum3 = a[2] + a[5] + a[8];

        int diagSum1 = a[0] + a[4] + a[8];
        int diagSum2 = a[2] + a[4] + a[6];

        return rowSum1 == rowSum2 && rowSum2 == rowSum3 
                && colSum1 == colSum2 && colSum2 == colSum3 
                    && diagSum1 == diagSum2;
    }

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        permute(new int[9], 0, 1);
        tr(count);
        return 1;
    }

    private static final Scanner scanner = new Scanner(InputBridge.getFileInputStream());

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
