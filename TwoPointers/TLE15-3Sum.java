// question link: https://leetcode.com/problems/3sum/

package TwoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            var res = new HashMap<Integer, Integer>();

            for (int j = i + 1; j < nums.length; j++) {
                if (res.containsKey(-nums[i] - nums[j])) {
                    List<Integer> validTriplet = new ArrayList<>();
                    validTriplet.add(nums[i]);
                    validTriplet.add(nums[j]);
                    validTriplet.add(-nums[i] - nums[j]);
                    validTriplet.sort(null);
                    if (!output.contains(validTriplet)) {
                        output.add(validTriplet);
                    }
                } else {
                    res.put(nums[j], j);
                }
            }

        }

        return output;

    }
}