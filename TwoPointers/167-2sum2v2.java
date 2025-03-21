// question link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

package TwoPointers;

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        if (numbers.length < 2) {
            return new int[] { 0, 0 };
        }

        int l = 0;

        for (int r = 1; r < numbers.length; r++) {
            while (l < r - 1 && numbers[r] + numbers[l] < target) {
                l++;
            }
            while (l > 0 && numbers[r] + numbers[l] > target) {
                l--;
            }

            if (numbers[r] + numbers[l] == target) {
                return new int[] { l + 1, r + 1 };
            }

        }

        return new int[] { 0, 0 };

    }
}