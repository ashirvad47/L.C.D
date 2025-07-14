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
    public int getDecimalValue(ListNode head) {
        int len=0;
        ListNode pointer = head;
        while(pointer!=null){
            pointer = pointer.next;
            len++;
        }

        int res=0;
        pointer= head;

        while(len!=0){
            len--;
            res += Math.pow(2,len)*pointer.val;
            pointer = pointer.next;
        }

        return res;
    }
}