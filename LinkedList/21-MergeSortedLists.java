// problem link: https://leetcode.com/problems/merge-two-sorted-lists/

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

class ConsiseIterativeSolution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode newHead = new ListNode();
        ListNode current = newHead;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;

        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return newHead.next;

    }
}

class InitialSolution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode newHead;

        if (list1.val < list2.val) {
            newHead = list1;
            list1 = list1.next;
        } else {
            newHead = list2;
            list2 = list2.next;
        }

        ListNode dummyNode = newHead;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                dummyNode.next = list1;
                list1 = list1.next;
                dummyNode = dummyNode.next;
            } else {
                dummyNode.next = list2;
                list2 = list2.next;
                dummyNode = dummyNode.next;
            }

        }

        while (list1 != null) {
            dummyNode.next = list1;
            list1 = list1.next;
            dummyNode = dummyNode.next;
        }

        while (list2 != null) {
            dummyNode.next = list2;
            list2 = list2.next;
            dummyNode = dummyNode.next;
        }

        return newHead;

    }
}
