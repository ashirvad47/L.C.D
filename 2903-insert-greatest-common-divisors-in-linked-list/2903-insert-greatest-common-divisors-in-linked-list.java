/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        ListNode pointer=head;
        while(pointer.next!=null){
            ListNode node = new ListNode();
            int a=pointer.val;
            int b=pointer.next.val;
            node.val = findGCD(a,b);
            node.next= pointer.next;
            pointer.next= node;
            pointer=node.next;
        }
        return head;
    }

    private int findGCD(int a, int b) {
        if (a > b)
            return findGCD(b, a);
        if (b % a == 0) {
            return a;
        } else {
            return findGCD(a,b%a);
        }

    }
}