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
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode pointer = head;
        int count = 1; 
        
        while (pointer.next != null) {
            count++;
            pointer = pointer.next;
        }
        
        int mid = count / 2;
        
        ListNode midPointer = head;
        for (int i = 0; i < mid; i++) {
            midPointer = midPointer.next;
        }
        
        return midPointer;
    }
}