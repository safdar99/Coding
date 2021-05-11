import java.util.Arrays;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        int shift = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - 48;
            int k = res.length - 1;
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - 48;
                int sum = d1 * d2 + carry + res[k - shift];
                res[k - shift] = sum % 10;
                carry = sum / 10;
                k--;
            }
            if (carry != 0) {
                res[k-shift] = carry;
            }
            shift++;
        }
        int k = 0;
        while (res[k++] == 0);
        StringBuilder ans = new StringBuilder();
        k--;
        while (k != res.length) {
            ans.append(res[k++]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.multiply("1235421415454545454545454544", "1714546546546545454544548544544545"));
    }
}