import java.io.*;
import java.util.*;

public class Solution {

    static void po(final Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    static final int n = 314159;
    static final int mod = (int)1e9 + 7;
    static final int limit = (int)1e5 + n;  //maximum no of bits required to store the number
    
    /*Here we are using long array to store powers of 2
     *because when power of 2 gets too large then
     *it will be overflown before being mod when it multiplied by 2
     *but using long prevents this overflow before mod
     */
     static long[] powersOf2(final int n) {
        final long pw2[] = new long[n];
        pw2[0] = 1;
        for (int i = 1; i < n; i++) {
            pw2[i] = (pw2[i-1] * 2) % mod;
        }
        return pw2;
    }

    static int getNoOfOnesBetween(final int[] dp, int l, int r) {
        if (l < 0) l = 0;
        if (r >= dp.length) r = dp.length - 1;
        if (r < l) return 0;
        final int onesAtR = dp[r];    //No of ones before and including rth position
        final int onesBeforeL = l == 0 ? 0 : dp[l-1];     //No of ones before and excluding lth position
        return onesAtR - onesBeforeL;   //No of ones between r and l both including
    }

    static int xorAndSum(String a, String b) {
        a = "10";
        b = "1010";
        final StringBuffer n1 = new StringBuffer(a).reverse();
        final StringBuffer n2 = new StringBuffer(b).reverse();
        final long[] pw2 = powersOf2(limit);

        final int[] dp = new int[n2.length()];
        //Array to store no of ones before and including ith position in "number n2"
        for (int i = 0; i < dp.length; i++) {
            dp[i] = n2.charAt(i) - '0';
            if (i > 0) {
                dp[i] += dp[i-1];
            }
        }
        
        int ans = 0;
        for (int i = 0; i < limit; i++) {
            int n1Bit;
            if (i >= n1.length()) {     //"number n1(i.e. a)" is exhausted therefore bit at this position in "n1" is 0
                n1Bit = 0;
            } else {
                n1Bit = n1.charAt(i) - '0';
            }
            final int count = getNoOfOnesBetween(dp, i-n, i);     //Count of no of ones in "number n2" between position "i" to"i-n"
            if (n1Bit == 1) {
                ans = (int)((ans + (n+1 - count) * pw2[i]) % mod);
            } else {
                ans = (int)((ans + count*pw2[i]) % mod);
            }
        }
        po(ans);
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        // String a = scanner.nextLine();

        // String b = scanner.nextLine();
        final String a = "", b = "";

        final int result = xorAndSum(a, b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
