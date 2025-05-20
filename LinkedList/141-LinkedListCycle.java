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
