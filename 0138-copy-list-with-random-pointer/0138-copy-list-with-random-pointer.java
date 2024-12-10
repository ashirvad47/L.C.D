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
        Node copyHead = head.next; // Reference to the head of the copied list
        while (pointer != null) {
            Node copy = pointer.next; // Copy node
            pointer.next = copy.next; // Restore original node's next pointer
            if (copy.next != null) {
                copy.next = copy.next.next; // Adjust copied node's next pointer
            }
            pointer = pointer.next; // Move to the next original node
        }

        return copyHead; // Return the head of the copied list
    }
}
