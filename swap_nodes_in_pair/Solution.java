import java.util.Arrays;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class Solution {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode p1 = head, p2, p3, p4;
        boolean firstTime = true;
        while (p1.next != null) {
            p2 = p1.next;
            p3 = p2 != null ? p2.next : null;
            p4 = p3 != null ? p3.next : null;
            if (firstTime) {
                p1.next = p3;
                p2.next = p1;
                head = p2;
                firstTime = false;
            } else {
                if (p3 == null) {
                    return head;
                }
                p1.next = p3;
                p2.next = p4;
                p3.next = p2;
                p1 = p2;
            }
        }
        return head;
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
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode l = getList(a);
        print(l);
        po("==========ANS=========");
        print(s.swapPairs(getList(a)));
    }
}