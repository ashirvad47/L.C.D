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
    public ListNode partition(ListNode head, int x) {
        ListNode low=  new ListNode(0);
        ListNode lowHead= low;
        ListNode high=  new ListNode(0);
        ListNode highHead= high;

        ListNode pointer= head;

        while(pointer!=null){
            if(pointer.val<x){
                ListNode node=  new ListNode(pointer.val);
                lowHead.next=node;
                lowHead = lowHead.next;
            }
            else if(pointer.val>=x){
                ListNode node=  new ListNode(pointer.val);
                highHead.next=node;
                highHead = highHead.next;
            }
            pointer = pointer.next;
        }

        lowHead.next= high.next;

        return low.next;
    }
}