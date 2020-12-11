import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString((o)));
    }

    static String[] ones = {"I", "X", "C", "M"};
    static String[] fives = {"V", "L", "D"};
    static String[] tens = {"X", "C", "M"};

    public String intToRoman(int num) {
        int index = 0;
        String ans = "";
        while (num > 0) {
            int x = num % 10;
            num = num / 10;
            if (x == 4) {
                ans = ones[index]+fives[index] + ans;
            } else if(x == 9) {
                ans = ones[index]+tens[index] + ans;
            } else if (x < 5) {
                for (int i = 0; i < x; i++) {
                    ans = ones[index] + ans;
                }
            } else {
                String roman = fives[index];
                for (int i = 0; i < x - 5; i++) {
                    roman += ones[index];
                }
                ans = roman + ans;
            }
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.intToRoman(3504));
    }
}