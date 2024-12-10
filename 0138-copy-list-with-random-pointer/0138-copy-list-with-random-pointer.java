/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Interweaving the list
        Node pointer = head;
        while (pointer != null) {
            Node newNode = new Node(pointer.val);
            newNode.next = pointer.next;
            pointer.next = newNode;

            pointer = newNode.next;
        }

        // Step 2: Assigning random pointers
        pointer = head;
        while (pointer != null) {
            if (pointer.random != null) {
                pointer.next.random = pointer.random.next;
            }
            pointer = pointer.next.next;
        }

        // Step 3: Deweaving the list
        pointer = head;
        Node copyHead = head.next; 
        while (pointer != null) {
            Node copy = pointer.next;
            pointer.next = copy.next; 
            if (copy.next != null) {//this condition prevents pointer.next from being null, think it ache se
                copy.next = copy.next.next;
            }
            pointer = pointer.next; 
        }

        return copyHead; 
    }
}
