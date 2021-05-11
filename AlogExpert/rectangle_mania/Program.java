package rectangle_mania;

import java.util.*;

//O(n^2) time | O(n) space
class Program {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public static int rectangleMania(Point[] coords) {
        // Write your code here.
        HashMap<Integer, HashSet<Integer>> xToY = new HashMap<>();
        for (Point p : coords) {
            putInMap(xToY, p.x, p.y);
        }
        // O(n)
        int count = 0;
        for (Point p1 : coords) {
            int ax = p1.x;
            int ay = p1.y;
            for (Point p2 : coords) {
                int cx = p2.x;
                int cy = p2.y;
                if (cx <= ax || cy <= ay)
                    continue;
                int bx = cx;
                int by = ay;
                int dx = ax;
                int dy = cy;
                if (xToY.get(bx).contains(by) && xToY.get(dx).contains(dy)) {
                    count++;
                }
            }
        }
        return count;
    }

    static void putInMap(HashMap<Integer, HashSet<Integer>> map, int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(value);
            map.put(key, set);
        }
    }

    class Point {
        public int x;
        public int y;
    
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }    
}

// 0(n^3) time | O(n) space
// class Program {
// static void po(Object... o) {
// System.out.println(Arrays.deepToString(o));
// }

// public static int rectangleMania(Point[] coords) {
// // Write your code here.
// HashMap<Integer, HashSet<Integer>> xToY = new HashMap<>();
// HashMap<Integer, HashSet<Integer>> yToX = new HashMap<>();
// for (Point p : coords) {
// putInMap(xToY, p.x, p.y);
// putInMap(yToX, p.y, p.x);
// }
// // O(n)
// int count = 0;
// for (Point p : coords) {
// int ax = p.x;
// int ay = p.y;
// for (int bx : yToX.get(ay)) {
// if (bx <= ax)
// continue;
// for (int cy : xToY.get(ax)) {
// if (cy <= ay)
// continue;
// if (xToY.get(bx).contains(cy)) {
// count++;
// }
// }
// }
// } // O(n^3)
// return count;
// }

// static void putInMap(HashMap<Integer, HashSet<Integer>> map, int key, int
// value) {
// if (map.containsKey(key)) {
// map.get(key).add(value);
// } else {
// HashSet<Integer> set = new HashSet<>();
// set.add(value);
// map.put(key, set);
// }
// }

// static class Point {
// public int x;
// public int y;

// public Point(int x, int y) {
// this.x = x;
// this.y = y;
// }
// }
// }