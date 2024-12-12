class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode low = new ListNode(0);
        ListNode high = new ListNode(0);

        ListNode lowHead = low;
        ListNode highHead = high;

        ListNode pointer = head;

        while (pointer != null) {
            if (pointer.val < x) {
                lowHead.next = pointer;
                lowHead = lowHead.next;
            } else {
                highHead.next = pointer;
                highHead = highHead.next;
            }
            pointer = pointer.next;
        }

        lowHead.next = high.next;
        highHead.next = null;

        return low.next;
    }
}
