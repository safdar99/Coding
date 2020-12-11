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
     
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head, prev = null;
        int i = 1;
        while (cur != null) {
            if (i == n+1) prev = head;
            else if (i > n+1) prev = prev.next;
            cur = cur.next;
            i++;
        }
        if (prev == null) return head.next;
        ListNode nodeToBeDeleted = prev.next;
        prev.next = nodeToBeDeleted.next;
        return head;
    }

    static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(a[0]);
        ListNode tmp = head;
        for (int i = 1; i < a.length; i++) {
            tmp.next = new ListNode(a[i]);
            tmp = tmp.next;
        }
        int n = 2;
        print(head);
        po();
        s.removeNthFromEnd(head, n);    
    }
}