import java.util.*;

//USING MIN HEAPS
public class Solution2 {
    static void po(Object... o) {
        System.out.println(Arrays.deepToString((o)));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode listNode: lists) {
            while (listNode != null) {
                pq.add(listNode.val);
                listNode = listNode.next;
            }
        }
        ListNode head = pq.isEmpty() ? null : new ListNode(pq.poll());
        ListNode tmp = head;
        while (!pq.isEmpty()) {
            tmp.next = new ListNode(pq.poll());
            tmp = tmp.next;
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
        Solution2 s = new Solution2();
        int[][] a = {
            {1,4,5},
            {1,3,4},
            {2,6}
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