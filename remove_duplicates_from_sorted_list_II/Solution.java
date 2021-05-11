import java.util.*;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, cur = head, next = head.next;
        boolean changeHead = false;
        while (cur != null) {
            if (next == null || cur.val != next.val) {
                if (changeHead) {
                    head = cur;
                    changeHead = false;
                }
                prev = cur;
                cur = next;
                next = next != null ? next.next : null;
            } else {
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
                if (prev != null) prev.next = next;
                else changeHead = true;
                cur = next;
                next = next != null ? next.next : null;
            }
        }
        if (changeHead) return null;    //if changeHead is still true after while that means all nodes in list are having duplicates
        return head;
    }
    static ListNode geList(int[] a) {
        ListNode head = null, tmp = null;
        for (int i = 0; i < a.length; i++) {
            ListNode b = new ListNode(a[i]);
            if (i == 0) {
                head = b;
                tmp = b;
            } else {
                tmp.next = b;
                tmp = b;
            }
        }
        return head;
    }

    static void printList(ListNode a) {
        while (a != null) {
            System.out.print(a.val + "->");
            a = a.next;
        }
        po();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = geList(new int[]{1,2,3,4,5,6,7});
        printList(head);
        printList(s.deleteDuplicates(head));
    }
}