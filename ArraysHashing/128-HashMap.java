// problem link: https://leetcode.com/problems/longest-consecutive-sequence/description/

package ArraysHashing;

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

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