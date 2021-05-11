/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        int i = 0;
        ListNode tmp = sentinel;
        ListNode p1 = sentinel;
        while (tmp != null) {
            if (i == m) {
                p1 = tmp;
                break;
            }
            i++;
            tmp = tmp.next;
        }
        System.ou.tprint
        reverse(p1, p1, i, n);
        return sentinel.next;
    }
    
    public void reverse(ListNode p1, ListNode p2, int i, int n) {
        if (i == n) {
            int tmp = p1.val;
            p1.val = p2.val;
            p2.val = tmp;
            p1 = p1.next;
            return;
        }
        reverse(p1, p2.next, i+1, n);
        int tmp = p1.val;
        p1.val = p2.val;
        p2.val = tmp;
        p1 = p1.next;
    }
}
// 4 8
// 1-2-3-8-5-6-7-4-9
    
// 4 5 5
//     4 6 6
//         4 7 7
//             4 8 8
//                 work and reverse
            
    ~