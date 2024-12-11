/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode RemoveNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        int dist = 0; 
        ListNode pointerRight = head;
        ListNode pointerLeft = head;

        while (pointerRight != null) {
            pointerRight = pointerRight.next;
            if (dist > n) pointerLeft = pointerLeft.next;
            dist++;
        }

        if (dist == n) {
            return head.next; 
        }

        pointerLeft.next = pointerLeft.next.next;

        return head;
    }
}
