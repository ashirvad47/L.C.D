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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode pointer = head;
        while (pointer != null && pointer.next != null) {
            int a = pointer.val;
            int b = pointer.next.val;
            ListNode node = new ListNode(findGCD(a, b)); 
            node.next = pointer.next;
            pointer.next = node;
            
            pointer = node.next;
        }
        return head;
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
