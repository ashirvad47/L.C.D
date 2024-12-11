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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pointer = head;
        int count = 0;

        while (pointer != null) {
            pointer = pointer.next;
            count++;
        }
        count = count / k;

        pointer = head;

        ListNode prev = null;
        ListNode curr = pointer;
        ListNode next = null;
        boolean first = true;
        ListNode prevTail = null;

        for (int i = 0; i < count; i++) {
            int temp = 0;
            ListNode back = curr;
            prev = null;

            while (temp < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                temp++;
            }

            if (first) {
                head = prev;
                first = false;
            } else {
                prevTail.next = prev;
            }

            prevTail = back;
        }

        prevTail.next = curr;

        return head;
    }
}
