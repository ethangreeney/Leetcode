package RandomStuff;

class Solution {

    static {
        for (int i = 0; i < 500; i++)
            singleNumber(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7 });
    }

    public static int singleNumber(int[] nums) {

        int min = 0, max = 0;

        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        boolean[] res = new boolean[max - min + 1];

        for (int i : nums) {
            res[i - min] = !res[i - min];
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i]) {
                return i + min;
            }
        }

        return -1;

    }
}