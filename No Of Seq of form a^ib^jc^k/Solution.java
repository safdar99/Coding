import java.util.*;
import java.io.*;

class Solution {
    static String a;
    static int[] dp;
    static int counter = 0;

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    static int getInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer ans = new StringBuffer();
        int t = getInt(br.readLine());
        while (t-- != 0) {
            a = br.readLine();
            dp = new int[a.length()];
            int count = 0;
            for (int i = 0; i < dp.length; i++) {
                dp[i] = -1;
            }
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == 'a') {
                    count += getNoOfSubseq(i);
                }
            }
            ans.append(count);
            ans.append("\n");
        }
        System.out.println(ans);
    }

    static int getNoOfSubseq(int index) {
        if (dp[index] != -1) return dp[index];
        counter++;
        int no = 0;
        if (a.charAt(index) == 'c') {
            no = 1;
        }
        for (int i = index+1; i < a.length(); i++) {
            if (a.charAt(i) == a.charAt(index) + 1 || a.charAt(i) == a.charAt(index)) {
                no += getNoOfSubseq(i);
            }
        }
        dp[index] = no;
        return no;
    }
}