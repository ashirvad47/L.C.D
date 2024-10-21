class MinStack {
    class Node {
        int val;
        int min;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    Node head;

    public void push(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            newNode.min = val;
        } else {
            newNode.min = Math.min(val, head.min);
        }
        newNode.next = head;
        head = newNode;
    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
