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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        ListNode pointer = head;
        int length=1;
        while(pointer.next!= null){
            pointer = pointer.next;
            length++;
        }

        pointer.next= head;

        pointer = head;

        k= length-k%length;

        int temp =0;

        while(temp <k-1){
            pointer= pointer.next;
            temp++;
        }

        head= pointer.next;
        pointer.next= null;

        return head;
    }
}