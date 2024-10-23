/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast.next != null) {
            slow.val += fast.val;

            if (fast.next.val == 0) {
                if (fast.next.next != null) {
                    slow.next = fast.next;
                    slow = fast.next;
                    slow.val = 0;
                } else {
                    slow.next = null;
                }
            }
            fast = fast.next;
        }
        return head;
    }
}