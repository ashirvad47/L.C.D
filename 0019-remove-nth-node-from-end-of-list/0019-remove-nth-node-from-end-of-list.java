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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next ==null || head == null) return null;
        int dist = 0; 
        ListNode pointerRight = head;
        ListNode pointerLeft = head;
        while(pointerRight != null){
            pointerRight = pointerRight.next;
            if(dist>n) pointerLeft= pointerLeft.next;
            dist++;
        }

        if (dist == n) {//FOR CASES WHEN n == no.of nodes
            return head.next; 
        }

        pointerLeft.next= pointerLeft.next.next;

        return head;
    }
}