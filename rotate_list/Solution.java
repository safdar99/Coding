import java.util.Arrays;

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
    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public ListNode rotateRight(ListNode head, int k) {
        int count = getCount(head);
        if (count == 0) return head;
        k = k % count;
        if (k == 0 || count == 1) return head; 
        ListNode p1 = null, p2 = null, p3;
        p3 = head; k--;
        if (k == 0) p2 = head;
        while (p3.next != null) {
            p3 = p3.next; k--;
            if (k == 0) p2 = head;
            else if (p2 != null) {
                p1 = p2;
                p2 = p2.next;
            }
        }
        if (p1 != null) p1.next = null;
        p3.next = head;
        head = p2;
        return head;
    }

    static int getCount(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    static ListNode getList(int[] a) {
        ListNode head = new ListNode(a[0]);
        ListNode tmp = head;
        for (int i = 1; i < a.length; i++) {
            tmp.next = new ListNode(a[i]);
            tmp = tmp.next;
        }
        return head;
    }

    static void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        po();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = getList(new int[]{0,1,2});
        printList(head);
        printList(s.rotateRight(head, 4));
    }
}