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
    enum ActiveList {
        list1, list2;
    }

    static void po(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, ans, tmp;
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l1.val <= l2.val) {
            ans = new ListNode(l1.val);
            p1 = p1.next;
        } else {
            ans = new ListNode(l2.val);
            p2 = p2.next;
        }
        tmp = ans;
        ListNode activeNode;
        while (p1 != null && p2 != null) {
            activeNode = p1.val <= p2.val ? p1 : p2;
            ActiveList activeList = activeNode == p1 ? ActiveList.list1 : ActiveList.list2;
            tmp.next = new ListNode(activeNode.val);
            tmp = tmp.next;
            activeNode = activeNode.next;
            if (activeList == ActiveList.list1) {
                p1 = activeNode;
            } else {
                p2 = activeNode;
            }
        }
        activeNode = p1 != null ? p1 : null;
        activeNode = p2 != null ? p2 : activeNode;
        while (activeNode != null) {
            tmp.next = new ListNode(activeNode.val);
            activeNode = activeNode.next;
            tmp = tmp.next;
        }
        print(ans);
        return ans;
    }

    static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = { 10, 20, 30 , 40};
        int[] b = {1, 12, 33, 44, 45, 60};
        ListNode l1 = new ListNode(a[0]);
        ListNode tmp = l1;
        for (int i = 1; i < a.length; i++) {
            tmp.next = new ListNode(a[i]);
            tmp = tmp.next;
        }
        ListNode l2 = new ListNode(b[0]);
        tmp = l2;
        for (int i = 1; i < b.length; i++) {
            tmp.next = new ListNode(b[i]);
            tmp = tmp.next;
        }
        print(l1);
        print(l2);
        s.mergeTwoLists(l1, l2);

    }
}