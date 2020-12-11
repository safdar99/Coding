import java.util.*;

class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    class State {
        String stateName;
        HashMap<Character, ArrayList<State>> routes;
        boolean isFinalState = false;
        boolean isVisited;

        State() {
            this.stateName = "q"+stateNo++;
            this.routes = new HashMap<>();
        }

        void addRoute(char c, State state) {
            ArrayList<State> routesByChar = routes.get(c);
            if (routesByChar != null) {
                routesByChar.add(state);
            } else {
                routesByChar = new ArrayList<>();
                routesByChar.add(state);
                routes.put(c, routesByChar);
            }
        }

        ArrayList<State> getRoutesByChar(char c) {
            ArrayList<State> routesByChar = routes.get(c);
            ArrayList<State> routesByDot = routes.get('.');
            if (routesByDot != null) {
                if (routesByChar != null) {
                    routesByChar = (ArrayList<State>)routesByChar.clone();
                    routesByChar.addAll(routesByDot);
                } else {
                    routesByChar = routesByDot;
                }
            }
            return routesByChar != null ? routesByChar : routes.get('.');
        }

        @Override
        public String toString() {
            String s = "| val: " + stateName + "; routes: ";
            for (Character key : routes.keySet()) {
                s += "(" + key + "=";
                for (State state : routes.get(key)) {
                    s += state.stateName+",";                   
                }
                s+= ")";
            }
            s += isFinalState + " |";
            return s;
        }
    }

    static int stateNo;
    public boolean isMatch(String s, String p) {
        stateNo = 0;
        State initState = new State();
        ArrayList<State> prevStates = new ArrayList<State>();
        prevStates.add(initState);
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            State state = new State();
            for (State prevState : prevStates) {
                prevState.addRoute(c, state);
            }
            char nextChar = i < p.length()-1 ? p.charAt(i+1) : '\0';
            if (nextChar == '*') {
                i++;
                state.addRoute(c, state);
            } else if (nextChar != '\0' || i == p.length()-1) {
                prevStates.clear();
            }
            prevStates.add(state); 
        }
        for (State node : prevStates) {
            node.isFinalState = true;        
        }
        // func(initState);
        //MARK:- Matching pattern
        return matchPattern(s, 0, initState, "");
    }

    boolean matchPattern(String s, int index, State currentState, String pad) {
        // po(pad, index, currentState.stateName);
        if (index == s.length()) return currentState.isFinalState;
        char c = s.charAt(index);
        ArrayList<State> routesByChar = currentState.getRoutesByChar(c);
        if (routesByChar != null) {
            for (State nextState: routesByChar) {
                if (matchPattern(s, index+1, nextState, pad + "     ")) return true;
            }
        }
        return false;
    }

    static void func(State state) {
        if (state.isVisited) return;
        state.isVisited = true;
        po(state);
        for (Character key: state.routes.keySet()) {
            for (State s: state.routes.get(key)) {
                func(s);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        po(s.isMatch("aab", "c*a*b"));
    }
}