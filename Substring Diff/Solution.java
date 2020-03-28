import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
        In this matrix the value at prevDiff[i][j] stores the
        number of mismatched characters in substring of s1 and s2
        where:
        substring of s1 = s1[x...i];
        substring of s2 = s2[x...j];
        x = min(i, j)
    */
    static int[][] prevDiff;

    //size of the strings 
    static int n;   

    static void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    static void calculatePreviousDifferences(String s1, String s2) {
        prevDiff = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    prevDiff[i][j] = prevDiff[i-1][j-1];
                } else {
                    prevDiff[i][j] = prevDiff[i-1][j-1] + 1;
                }
            }
        }
    }

    static boolean isSubstringLengthAvailable(int len, int limit) {
        for (int i = 1; i <= n - len; i++) {
            for (int j = 1; j <= n - len; j++) {
                if (prevDiff[i+len-1][j+len-1] - prevDiff[i-1][j-1] <= limit) {
                    return true;
                }
            }
        }
        return false;
    }

    // Complete the substringDiff function below.
    static int substringDiff(int k, String s1, String s2) {
        s1 = " " + s1;
        s2 = " " + s2;
        n = s1.length();
        calculatePreviousDifferences(s1, s2);

        //Binary search for max length of substring 
        int l = 0;
        int r = n-1;
        while (l < r) {
            int mid = (l+r+1)/2;
            if (isSubstringLengthAvailable(mid, k)) {
                l = mid;
            } else {
                r = mid-1;
            }
        }
        return l;
    }

    private static final Scanner scanner = new Scanner(InputBridge.getFileInputStream())    ;

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Output.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] kS1S2 = scanner.nextLine().split(" ");

            int k = Integer.parseInt(kS1S2[0]);

            String s1 = kS1S2[1];

            String s2 = kS1S2[2];

            int result = substringDiff(k, s1, s2);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
