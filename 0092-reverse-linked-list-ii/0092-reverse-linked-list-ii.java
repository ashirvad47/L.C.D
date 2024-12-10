class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = head;
        ListNode back = null; // for safety cases when n = 1
        
        for(int i = 1; i < left; i++){
            back = pointer;
            pointer = pointer.next;
        }
        
        ListNode prev = null;
        ListNode curr = pointer;
        ListNode next = null;

        while(left <= right){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

            left++;
        }

        if(back != null){
            back.next = prev;
        } else {
            dummy.next = prev;
        }

        pointer.next = curr;
        return dummy.next;
    }
}