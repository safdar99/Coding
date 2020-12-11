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

    public ListNode reverseKGroup(ListNode head, int k) {
        // ListNode p1 = head, p2 = p1.next, p3 = p2.next, p4 = p3.next, p5 = p4.next, p6 = p5.next, p7 = p6.next, p8 = p7.next;
        ListNode curHead = head, prevTail = null, ansHead = head;
        while (curHead != null) {
            ListNode ptr = curHead;
            int i = 0;
            while (ptr != null) {
                if (++i == k) break;
                ptr = ptr.next;
            }
            if (ptr == null) {
                return ansHead;
            }
            ListNode curTail = ptr, upcomingNode = curTail.next;
            if (i == k) {
                reverseList(curHead, curTail);
                if (prevTail == null) {
                    ansHead = curTail;
                    prevTail = curHead;
                } else {
                    prevTail.next = curTail;
                    prevTail = curHead;
                }
                curHead.next = upcomingNode;
                curHead = upcomingNode;
            }
        }
        return ansHead;   
    }

    static void reverseList(ListNode head, ListNode tail) {
        ListNode prev = null, cur = head, upcoming;
        while (cur != tail) {
            upcoming = cur.next;
            cur.next = prev;
            prev = cur;
            cur = upcoming;
        }
        if (cur != null) {
            cur.next = prev;
        }
    } 
    static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }

    static ListNode getList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode tmp = head;
        for (int i = 1; i < arr.length; i++){
            tmp.next = new ListNode(arr[i]);
            tmp = tmp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,2,3,4,5,6,7,8};
        int k = 3;
        ListNode head = getList(a);
        po("===========INPUT===============");
        print(head);
        po("===========ANS=================");
        print(s.reverseKGroup(head, k));
    }
}  