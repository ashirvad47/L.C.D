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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int carry = 0;
        ListNode l3 = new ListNode(0); // Create a dummy node for the result list
        ListNode head = l3;           // Use 'head' to track the start of the list

        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0; 
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;       
            carry = sum / 10;                   
            addNode(l3, sum % 10);  
            l3 = l3.next;           
                                

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            addNode(l3, carry);
            l3 = l3.next; 
        }

        return head.next;
    }

    public void addNode(ListNode l3, int val) {
        l3.next = new ListNode(val);
           
    }
}
