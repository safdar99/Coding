import java.util.Arrays;
import java.util.HashSet;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    int n;
    static int[] fact = new int[] { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

    public String getPermutation(int n, int k) {
        this.n = n;
        return permuteFuther(new int[n + 1], new StringBuilder(), k, "").toString();
    }

    StringBuilder permuteFuther(int[] domain, StringBuilder seq, int k, String pad) {
        // po(pad, domain, seq, k);
        int npp = 0;
        int nsfx = fact[n - (seq.length() + 1)];
        for (int i = 1; i < domain.length; i++) {
            if (domain[i] == -1)
                continue;
            npp += nsfx;
            // po(pad, npp, nsfx);
            if (k > npp) {
                continue;
            } else if (k < npp) {
                domain[i] = -1;
                permuteFuther(domain, seq.append(i), nsfx - (npp - k), pad + "      ");
                break;
            } else {
                seq.append(i);
                domain[i] = -1;
                for (int j = domain.length - 1; j > 0; j--) {
                    seq.append(domain[j] != -1 ? j : "");
                }
                break;
            }
        }
        return seq;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.getPermutation(1,1));
    }
}