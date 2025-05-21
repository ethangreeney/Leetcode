// problem link: https://leetcode.com/problems/two-sum/

package TwoPointers;

import java.util.HashMap;

class solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> seen = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {

            if (seen.containsKey(target - nums[i])) {
                return new int[] { i, seen.get(target - nums[i]) };
            }

            seen.put(nums[i], i);

        }

        return new int[] { 0, 0 };

    }
}
