// problem link: https://leetcode.com/problems/reverse-linked-list/

package LinkedList;

public class ListNode {
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

class Solution {
    ListNode newHead;

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        reverseList(null, head);
        return newHead;

    }

    // 0 - 1 - 2 - 3 - 4

    private void reverseList(ListNode head, ListNode headNext) {

        if (headNext.next != null) {
            reverseList(headNext, headNext.next);
        }

        if (headNext.next == null) {
            newHead = headNext;
        }

        headNext.next = head;

    }

}