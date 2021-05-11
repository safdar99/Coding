import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int[][] cost = constructTheCostMat(words, maxWidth);
        int[] minCostArr = new int[n];
        int[] splitArr = new int[n];
        constructTheMinCostMat(minCostArr, splitArr, cost);
        // po(minCostArr);
        // po(splitArr);
        List<String> ans = new ArrayList<>();
        int i = 0, j = splitArr[i];
        while (true) {
            String[] subWords = new String[j-i];
            for (int k = i, l = 0; k  < j; k++, l++) {
                subWords[l] = words[k];
            }
            ans.add(justifyWords(subWords, maxWidth, false));
            i = j;
            if (j == n) break;
            else j = splitArr[j];
        }
        for (String s: ans) {
            po(s);
        }
        return ans;
    }

    String justifyWords(String[] words, int maxWidth, boolean isLastLine) {
        StringBuilder line = new StringBuilder();
        //no of chars
        int noChars = 0;
        //no of spaces
        int noSpaces = words.length-1;
        for (String word: words) noChars += word.length();
        //no of empty slots
        int noSlots = maxWidth - (noChars + noSpaces);
        if (isLastLine) {
            int x = 0;
            for (int i = 0; i < words.length-1; i++) {
                line.append(words[i]);
                line.append(' ');
                x += words[i].length() + 1;
            }
            line.append(words[words.length-1]);
            x += words[words.length-1].length();
            po(x);
            while (x++ != maxWidth) line.append(' ');
            return line.toString();
        }
        //no of regular or equal empty slots that can be divided between words
        int regSlots;
        int extraSlots;
        if (noSpaces == 0) {
            regSlots = noSlots;
            extraSlots = 0;
        } else {
            regSlots = noSlots / noSpaces;
            extraSlots = noSlots % noSpaces;
        }
        for (int i = 0; i < words.length-1; i++) {
            String word = words[i];
            line.append(word);
            int padding = regSlots + (extraSlots > 0 ? 1 : 0) + 1;//for space
            for (int k = 0; k < padding; k++) {
                line.append(' ');
            } 
            extraSlots--;
        }
        po(words);
        line.append(words[words.length-1]);
        return line.toString();
    }

    int[][] constructTheCostMat(String[] words, int maxWidth) {
        int n = words.length;
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            cost[i][i] = maxWidth - words[i].length();
            for (int j = i+1; j < n; j++) {
                cost[i][j] = cost[i][j-1] - words[j].length() - 1;
            }
        }
        //Squaring the cost so that is effective
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cost[i][j] < 0) {
                    cost[i][j] = Integer.MAX_VALUE;
                } else {
                    cost[i][j] = (int) Math.pow(cost[i][j], 2);
                }
            }
        }
        return cost;
    }

    void constructTheMinCostMat(int[] minCostArr, int[] splitArr, int[][] cost) {
        int n = minCostArr.length;
        for (int i = n-1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            int split = -1;
            for (int j = n; j > i; j--) {
                if (cost[i][j-1] == Integer.MAX_VALUE) continue;
                int curCost = cost[i][j-1] + (j == n ? 0 : minCostArr[j]);
                if (minCost > curCost) {
                    minCost = curCost;
                    split = j;
                }
            }
            splitArr[i] = split;
            minCostArr[i] = minCost;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // String[] words = new String[] {"What","must","be","acknowledgment","shall","be"};
        // String[] words = new String[] {"This", "is", "a", "example", "of", "justification"};
        String[] words = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
        po(s.fullJustify(words, 16));
    }
}