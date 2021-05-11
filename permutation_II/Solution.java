import java.lang.reflect.Array;
import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    List<List<Integer>> ans;
    int index;
    public List<List<Integer>> permuteUnique(int[] nums) {
        index = 0;
        ans = new ArrayList<List<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], count+1);
            }
        }
        utils(map, new ArrayList<>(), "");
        return ans; 
    }

    void utils(HashMap<Integer, Integer> map, ArrayList<Integer> list, String pad) {
        // po(pad, map, list);
        if (map.isEmpty()) {
            ans.add(list);
            return;
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            HashMap<Integer, Integer> map2 = (HashMap<Integer, Integer>) map.clone();
            ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone();
            list2.add(entry.getKey());
            if (entry.getValue() == 1) {
                // po("removing");
                map2.remove(entry.getKey());
            } else {
                map2.put(entry.getKey(), entry.getValue()-1);
            }
            utils(map2, list2, pad + "    ");
        }
    }   

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.permuteUnique(new int[]{1,1,2}));
    }
}