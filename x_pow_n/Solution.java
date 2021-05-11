import java.util.Arrays;

class Solution {

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        if (n == Integer.MIN_VALUE) {
            double prod = utils(x, Math.abs(n+1), "");
            po(prod);
            return 1/(prod*x);
        }
        double prod = utils(x, Math.abs(n), "");
        return n > 0 ? prod : 1/prod;
    }

    double utils(double x, int n, String pad) {
        // po(pad, (int)x, n);
        if (n == 2) return x*x;
        if (n % 2 == 0) {
            double prod = utils(x, n/2, pad + "    ");
            return prod*prod;
        } else {
            return x*utils(x, n-1, pad + "    ");
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.myPow(1, -2147483648));
    }
}