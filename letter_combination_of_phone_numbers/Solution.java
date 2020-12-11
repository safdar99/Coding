import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    static HashMap<Character, Character[]> keyPad;
    static {
        keyPad = new HashMap<>();
        keyPad.put('2', new Character[]{'a', 'b', 'c'});
        keyPad.put('3', new Character[]{'d', 'e', 'f'});
        keyPad.put('4', new Character[]{'g', 'h', 'i'});
        keyPad.put('5', new Character[]{'j', 'k', 'l'});
        keyPad.put('6', new Character[]{'m', 'n', 'o'});
        keyPad.put('7', new Character[]{'p', 'q', 'r', 's'});
        keyPad.put('8', new Character[]{'t', 'u', 'v'});
        keyPad.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }

    List<String> ans;
    
    public List<String> letterCombinations(String digits) {
        ans = new LinkedList<>();
        if (digits.isEmpty()) return ans;
        mapKeys(digits, 0, new StringBuffer());
        return ans;   
    }

    void mapKeys(String no, int index, StringBuffer s) {
        if (index == no.length()) {
            ans.add(s.toString());
            return;
        }
        Character[] childs = keyPad.get(no.charAt(index));
        for (Character c: childs) {
            StringBuffer scopy = new StringBuffer(s.toString());
            mapKeys(no, index+1, scopy.append(c));
        }
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.letterCombinations(""));
    }
}