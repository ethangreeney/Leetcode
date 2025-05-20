package RandomStuff;

class Random {
    int val;
    Random next;

    Random() {
    }

    Random(int val) {
        this.val = val;
    }

    Random(int val, Random next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public Random mergeTwoLists(Random list1, Random list2) {

        Random dummyNode = new Random();
        Random current = dummyNode;

        while (current != null && list1 != null && list2 != null) {
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

        return dummyNode.next;

    }
}