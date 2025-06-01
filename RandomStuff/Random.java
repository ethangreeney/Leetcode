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

class Solution2 {

    public static void persistence(int repititionCount) {

        long[] maxPersistence = { 0, 0 };
        long[] currentPersistence;

        for (int i = 1; i <= repititionCount; i++) {
            currentPersistence = calculatePersistence(i);
            maxPersistence = currentPersistence[0] > maxPersistence[0] ? currentPersistence : maxPersistence;
        }

        printPersistence(maxPersistence[1]);

    }

    private static long[] calculatePersistence(long i) {

        long originalI = i;

        int noOfTurns = 0;

        while (String.valueOf(i).length() > 1) {

            char[] iStringArr = String.valueOf(i).toCharArray();

            long productOfDigits = 1;

            for (int y = 0; y < iStringArr.length; y++) {
                productOfDigits *= Integer.parseInt(String.valueOf(iStringArr[y]));
            }

            i = productOfDigits;
            noOfTurns++;
        }

        return new long[] { noOfTurns, originalI };
    }

    private static void printPersistence(long i) {

        System.out.println(i);

        while (String.valueOf(i).length() > 1) {

            char[] iStringArr = String.valueOf(i).toCharArray();

            long productOfDigits = 1;

            for (int y = 0; y < iStringArr.length; y++) {
                productOfDigits *= Integer.parseInt(String.valueOf(iStringArr[y]));
            }

            i = productOfDigits;
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        persistence(1000000000);
    }

}