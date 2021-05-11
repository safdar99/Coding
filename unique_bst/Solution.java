class Solution {
    public int numTrees(int n) {
        int[] trees = new int[n+1];
        trees[0] = 1;
        trees[1] = 1;
        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                count += trees[j-1]*trees[i-j];
            }
            trees[i] = count;
        }
        return trees[n];
    }
}

// h(3)
//     c=0
//     x=1
//     c+=h(0)
//         return 1
//     c+=h(2)
//         x=1
//         c+=h(0)
//             return 1
//         c+=h(1)
//             return 1
//         t[2]=2
    
