// problem link: https://leetcode.com/problems/reverse-linked-list/

package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Iterative {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode next = null;

        while (head != null) {

            next = head.next;

            head.next = prev;

            prev = head;
            head = next;

        }

        return prev;

    }
}

class RecursiveMoreIdiomatic {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);

        head.next.next = head;

        head.next = null;

        return newHead;

    }
}

class Recursive {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        return reverseList(null, head);

    }

    private ListNode reverseList(ListNode head, ListNode headNext) {

        ListNode newHead;

        if (headNext.next != null) {
            newHead = reverseList(headNext, headNext.next);
        } else {
            newHead = headNext;
        }

        headNext.next = head;

        return newHead;

    }

}