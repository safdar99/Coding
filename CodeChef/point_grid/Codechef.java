/* package codechef; // don't place package name! */

import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception {
		// your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tests = getInt(input[0]);
        StringBuilder ans = new StringBuilder();
        while (tests-- > 0) {
            input = br.readLine().split(" ");
            int n = getInt(input[0]);
            input = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = getInt(input[i]);
            }
            ans.append(utils(arr));
            ans.append("\n");
        } 
        System.out.println(ans);
	}

    static int utils(int[] arr) {
        int len = arr.length;
        int steps = arr[len-1];
        for (int i = len-2; i > -1; i--) {
            if (arr[i] >= arr[i+1]) {
                steps += arr[i]-arr[i+1]+1;
            } else {
            }
        }
        return steps;
    }

    static int getInt(String s) {
        return Integer.parseInt(s);
    }

}
