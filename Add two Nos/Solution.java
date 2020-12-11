import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        po('s');
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;
            int sum = (d1 + d2 + carry) % 10;
            po(d1, d2, carry, sum);
            carry = (d1 + d2 + carry) / 10;
            ListNode node = new ListNode(sum);
            prev.next = node;
            l1 = l1.next;
            l2 = l2.next;
            prev = node;
        }
        if (carry != 0) {
            prev.next = new ListNode(carry);
        }
        travList(fakeHead);
        return fakeHead.next;
    }   

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {5};
        int[] b = {5};

        ListNode l1 = null;
        for (int i = 0; i < a.length; i++) {
            l1 = new ListNode(a[i], l1);
        }
        
        ListNode l2 = null;
        for (int i = 0; i < b.length; i++) {
            l2 = new ListNode(b[i], l2);
        }
        
        travList(l1);
        travList(l2);
        s.addTwoNumbers(l1, l2);
    }

    static void travList(ListNode l) {
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
        po();
    }
}
