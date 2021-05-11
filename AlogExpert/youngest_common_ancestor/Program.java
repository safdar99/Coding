package youngest_common_ancestor;

import java.util.*;

//O(d) time | O(1) space
class Program {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendant1,
            AncestralTree descendant2) {
        // Write your code here.
        int generation1 = getGeneration(descendant1);
        int generation2 = getGeneration(descendant2);
        if (generation2 > generation1) {
            while (generation2 != generation1) {
                generation2--;
                descendant2 = descendant2.ancestor;
            }
        } else {
            while (generation1 != generation2) {
                generation1--;
                descendant1 = descendant1.ancestor;
            }
        }
        return moveUpTillEqual(descendant1, descendant2);
    }

    static AncestralTree moveUpTillEqual(AncestralTree d1, AncestralTree d2) {
        while (d1 != d2) {
            d1 = d1.ancestor;
            d2 = d2.ancestor;
        }
        return d1;
    }

    static int getGeneration(AncestralTree descendant) {
        int generation = -1;
        AncestralTree tmp = descendant;
        while (tmp != null) {
            generation++;
            tmp = tmp.ancestor;
        }
        return generation;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}
