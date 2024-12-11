/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode DeleteDuplicates(ListNode head) {
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