import java.util.*;

// USING DIVIDE AND CONQUER
public class Solution3 {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString((o)));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return divideAndRule(0, lists.length-1, lists);
    }

    ListNode divideAndRule(int start, int end, ListNode[] lists) {
        if (start == end) return lists[start];
        int mid = (start + end)/2;
        ListNode n1 = divideAndRule(start, mid, lists);
        ListNode n2 = divideAndRule(mid+1, end, lists);
        return mergeLists(n1, n2);
    }

    ListNode mergeLists(ListNode n1, ListNode n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        boolean shouldContinue = false;
        boolean isFirstTime = true;
        ListNode head = null, ptr = null;
        while (shouldContinue || isFirstTime) {
            shouldContinue = false;
            int n1Val = n1 != null ? n1.val : Integer.MAX_VALUE;
            int n2Val = n2 != null ? n2.val : Integer.MAX_VALUE;
            if (n1Val <= n2Val && n1Val != Integer.MAX_VALUE) {
                if (isFirstTime) {
                    head = new ListNode(n1.val);
                    ptr = head;
                } else {
                    ptr.next = new ListNode(n1.val);
                    ptr = ptr.next;
                }
                n1 = n1.next;
                shouldContinue = true;
            } else if (n2Val != Integer.MAX_VALUE) {
                if (isFirstTime) {
                    head = new ListNode(n2.val);
                    ptr = head;
                } else {
                    ptr.next = new ListNode(n2.val);
                    ptr = ptr.next;
                }
                n2 = n2.next;
                shouldContinue = true;
            }
            isFirstTime = false;
        }
        return head;
    }

    void appendNode(boolean isFirstTime, ListNode head, ListNode ptr,  ListNode node) {
        po("appending");
        
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
        Solution3 s = new Solution3();
        int[][] a = {
            {1,4,5},
            {1,3,4},
            {}
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