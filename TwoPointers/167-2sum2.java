// question link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

package TwoPointers;

class Solution {

    static {

        for (int i = 0; i < 500; i++) {
            twoSum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 14);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {

        int l = 0;
        int r = numbers.length - 1;

        for (; l < r; r--) {
            while (l < r && numbers[r] + numbers[l] > target) {
                r--;
            }
            while (l < r && numbers[r] + numbers[l] < target) {
                l++;
            }
            if (numbers[r] + numbers[l] == target) {
                return new int[] { ++l, ++r };
            }
        }

        return new int[] { 0, 0 };

    }
}