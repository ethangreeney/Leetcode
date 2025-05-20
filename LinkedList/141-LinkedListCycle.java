package LinkedList;

import java.util.HashSet;
import java.util.Set;

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

class TwoPointers {
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }

        }

        return false;

    }
}

class IterativeHashSet {
    public boolean hasCycle(ListNode head) {

        Set<ListNode> seen = new HashSet<ListNode>();

        while (head != null) {

            if (!seen.add(head)) {
                return true;
            }

            head = head.next;

        }

        return false;
    }
}
