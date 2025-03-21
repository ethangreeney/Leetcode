// problem link: https://leetcode.com/problems/longest-consecutive-sequence/description/

class Solution {
    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int min = nums[0];

        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        var res = new boolean[max - min + 1];

        for (int i : nums) {
            res[i - min] = true;
        }

        int leftPointer = 0;
        int rightPointer = 0;
        int maxLength = 0;

        for (; rightPointer < res.length; rightPointer++) {
            if (res[rightPointer] == true) {
                maxLength = Math.max(rightPointer - leftPointer + 1, maxLength);
            } else {
                leftPointer = rightPointer + 1;
            }
        }

        return maxLength;

    }
}