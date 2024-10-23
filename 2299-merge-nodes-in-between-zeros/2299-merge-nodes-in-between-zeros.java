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
public class Solution {
    public ListNode mergeNodes(ListNode head) {
        head = head.next;
        ListNode slow = head;
        while (slow != null) {
            ListNode fast = slow;   
            int sum = 0;
            while (fast.val != 0) {
                sum += fast.val;
                fast = fast.next;
            }
            slow.val = sum;   
            slow.next = fast.next;   
            slow = slow.next;
        }
        return head;
    }
}