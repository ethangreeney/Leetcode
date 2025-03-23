// question link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

package TwoPointers;

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int l = 0, r = numbers.length - 1;

        while (l < r) {
            if (numbers[r] + numbers[l] < target) {
                l++;
            } else if (numbers[r] + numbers[l] > target) {
                r--;
            } else {
                return new int[] { l + 1, r + 1 };
            }
        }

        return new int[] { 0, 0 };
    }

}