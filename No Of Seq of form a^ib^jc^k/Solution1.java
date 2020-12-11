import java.util.*;
import java.io.*;

class Solution1 {
    static String a;

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
            int count = calSubSeq();
            ans.append(count);
            ans.append("\n");
        }
        System.out.println(ans);
    }

    static int calSubSeq() {
        int aCount = 0, bCount = 0, cCount = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'a') {
                aCount += aCount + 1;
            } else if (a.charAt(i) == 'b') {
                bCount += bCount + aCount;
            } else if (a.charAt(i) == 'c') {
                cCount += cCount + bCount;
            }
        }
        return cCount;
    }
}