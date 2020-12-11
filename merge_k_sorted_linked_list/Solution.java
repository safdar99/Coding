import java.util.*;

//USING BRUTE FORCE
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString((o)));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        boolean isFirstTime = true;
        ListNode ansHead = null;
        int curMin = Integer.MAX_VALUE;
        int activeIndex = -1;
        ListNode traverser = null;
        while (curMin != Integer.MAX_VALUE || isFirstTime) {
            curMin = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                int val = node != null ? node.val : Integer.MAX_VALUE;
                if (curMin > val) {
                    curMin = val;
                    activeIndex = i;
                }
            }
            if (curMin != Integer.MAX_VALUE && isFirstTime) {
                ansHead = new ListNode(curMin);
                traverser = ansHead;
            } else if (curMin != Integer.MAX_VALUE) {
                traverser.next = new ListNode(curMin);
                traverser = traverser.next;
            }
            isFirstTime = false;
            if (activeIndex != -1 && lists[activeIndex] != null) {
                lists[activeIndex] = lists[activeIndex].next;
            }
        }
        return ansHead;
    }

    static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }

    static ListNode[] getList(int[][] arr) {
        ListNode[] lists = new ListNode[arr.length];
        int i = 0;
        for (int[] a: arr) {
            if (a.length == 0) {
                lists[i++] = null;
                continue;
            }
            ListNode head = new ListNode(a[0]);
            ListNode tmp = head;
            int j = 1;
            while (j < a.length) {
                tmp.next = new ListNode(a[j++]);
                tmp = tmp.next;
            }
            lists[i++] = head;
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {
            // {1,4,5},
            // {1,3,4},
            // {}
        };
        ListNode[] lists = getList(a);
        for (ListNode listNode : lists) {
            print(listNode);
        }
        ListNode[] input = getList(a);
        ListNode ans = s.mergeKLists(input); 
        print(ans);
    }
}