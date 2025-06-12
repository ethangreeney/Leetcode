// problem link: https://leetcode.com/problems/min-stack/

package Stacks;

class MinStack { // 4ms beats 97%

    Node head = new Node();

    public MinStack() {
    }

    public void push(int val) {

        if (head.next != null) {
            Node nextNode = new Node(val, head.next, head.next.currentMin < val ? head.next.currentMin : val);
            head.next = nextNode;
        } else {
            Node nextNode = new Node(val, head.next, val);
            head.next = nextNode;
        }

    }

    public void pop() {
        head.next = head.next.next;
    }

    public int top() {
        return head.next.val;
    }

    public int getMin() {
        return head.next.currentMin;
    }

    class Node {

        int val;
        Node next;
        int currentMin;

        Node(int value, Node nextNode, int currentMinimum) {
            val = value;
            next = nextNode;
            currentMin = currentMinimum;
        }

        Node() {
        }
    }

}
