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
        ListNode pointer = head;

        int count=0;

        while(pointer.next!=null){
            count++;
            pointer=pointer.next;
        }

        ListNode midpointer = head;
        int mid=count/2;
        if(count%2==0){
            for(int i =0;i < mid;i++){
                midpointer = midpointer.next;
            }
            return midpointer;
        }else{
            for(int i =0;i < mid;i++){
                midpointer = midpointer.next;
            }
            return midpointer.next;
        }
    }
}