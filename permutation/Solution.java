import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    List<List<Integer>> ans;
    int index;
    public List<List<Integer>> permute(int[] nums) {
        index = 0;
        ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        utils(set, new ArrayList<Integer>(),"");
        return ans; 
    }

    void utils(ArrayList<Integer> set, ArrayList<Integer> curSeq, String pad) {
        po(pad, curSeq);
        if (set.isEmpty()) {
            ans.add(curSeq);
            index++;
            return;
        }
        for (Integer x: set) {
            ArrayList<Integer> set2 = (ArrayList<Integer>)set.clone();
            ArrayList<Integer> curSeq2 = (ArrayList<Integer>) curSeq.clone();
            set2.remove(x);
            curSeq2.add(x);
            utils(set2, curSeq2, pad + "     ");
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.permute(new int[]{1,1,2}));
    }
}