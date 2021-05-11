import java.util.*;

class Node {
    Map<Character, Node> routes;
    boolean isFinal;
    String name;
    Node(String name, boolean isFinal) {
        this.name = name;
        this.isFinal = isFinal;
    }

    Node getNextStateForRoute(char c) {
        return routes.get(c);
    }
}
public class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public boolean isNumber(String s) {
        Node q8 = new Node("q8", true);
        q8.routes = Map.of('d', q8);

        Node q7 = new Node("q7", false);
        q7.routes = Map.of('d', q8);
        
        Node q6 = new Node("q6", false);
        q6.routes = Map.of(
            'd', q8,
            '+', q7, 
            '-', q7);

        Node q5 = new Node("q5", true);
        q5.routes = Map.of(
            'd', q5,
            'e', q6);

        Node q4 = new Node("q4", false);
        q4.routes = Map.of('d', q5);

        Node q3 = new Node("q3", false);
        q3.routes = Map.of(
            '+', q4,
            '-', q4, 
            'd', q5);

        Node q2 = new Node("q2", true);
        q2.routes = Map.of('d', q2, '.', q4, 'e', q3);

        Node qi = new Node("qi", false);
        qi.routes = Map.of(
            'd', q2
        );

        Node q1 = new Node("q1", false);
        q1.routes = Map.of(
            'd', q2,
            '.', qi
        );

        Node q0 = new Node("q0", false);
        q0.routes = Map.of(
            '.', qi,
            '+', q1, 
            '-', q1, 
            'd', q2);

        s = s.trim();
        Node node = q0;
        for (int i = 0; i < s.length() && node != null; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') c = 'd';
            else if (c == 'd') c = 'c';
            node = node.getNextStateForRoute(c);
            if (node != null) {
                // po(s.charAt(i) + "-> " + node.name);
            }
        }
        return node != null && node.isFinal;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.isNumber("1."));
    }
}