// problem link: https://leetcode.com/problems/single-number/description/

package BitManipulation;

class Solution {
    public int singleNumber(int[] nums) {

        int bitManip = 0;

        for (int i : nums) {
            bitManip ^= i;
        }

        return bitManip;

    }
}