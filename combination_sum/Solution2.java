import java.util.*;

class Solution2 {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();    
        Arrays.sort(candidates);
        utils(candidates, 0, 0, target, new ArrayList<Integer>(), ans);
        return ans;
    }

    void utils(int[] arr, int index, int curS, int tar, ArrayList<Integer> list, List<List<Integer>> ans) {
        po(arr, index, curS, tar, list);
        if (curS == tar)  {
            ans.add(list);
            return;
        }
        int prev = -1;
        for (int i = index; i < arr.length; i++) {
            if (arr[i] == prev) continue;
            if (curS+arr[i] > tar) return;
            ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone();
            list2.add(arr[i]);
            utils(arr, i+1, curS+arr[i], tar, list2, ans);
            prev = arr[i];
        }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        po(s.combinationSum(candidates, target));
    }
}