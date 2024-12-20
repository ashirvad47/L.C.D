/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next==null) return false;

        ListNode pointer1 = head;
        ListNode pointer2 = head.next;

        while(pointer2!=null && pointer2.next!=null){
            if(pointer1==pointer2) return true;
            pointer1= pointer1.next;
            pointer2= pointer2.next.next;
        }

        return false;
    }
}