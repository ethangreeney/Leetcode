// problem link: https://leetcode.com/problems/longest-consecutive-sequence/description/

import java.util.HashSet;

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

        if (max - min < 1000000) {

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
        } else {
            var numsSet = new HashSet<Integer>();

            for (int i : nums) {
                numsSet.add(i);
            }

            int maxLen = 1;

            for (int i : numsSet) {

                if (!numsSet.contains(i - 1)) {

                    int currentLen = 1;

                    while (numsSet.contains(++i)) {
                        currentLen++;
                    }

                    maxLen = Math.max(maxLen, currentLen);
                }

            }
            return maxLen;
        }
    }
}