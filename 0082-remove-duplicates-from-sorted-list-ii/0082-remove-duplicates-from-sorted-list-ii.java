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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pointerFast = head;
        ListNode dummyHead = new ListNode();
        dummyHead.next= head;
        ListNode pointerSlow = dummyHead;

        while(pointerFast!=null){

            if(pointerFast.next!=null && pointerFast.val == pointerFast.next.val){

                while(pointerFast.next!=null && pointerFast.val == pointerFast.next.val){
                    pointerFast = pointerFast.next;
                }

                pointerFast = pointerFast.next;
                pointerSlow.next = pointerFast;
            }else{
                 pointerFast= pointerFast.next;
                 pointerSlow= pointerSlow.next;
            }
           
        }
        
        return dummyHead.next;
    }
}
