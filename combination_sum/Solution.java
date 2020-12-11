import java.util.*;

class Solution {
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
        for (int i = index; i < arr.length; i++) {
            if (curS+arr[i] > tar) return;
            ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone();
            list2.add(arr[i]);
            utils(arr, i, curS+arr[i], tar, list2, ans);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidates = {2,7,6,3,5,1};
        int target = 9;
        po(s.combinationSum(candidates, target));
    }
}