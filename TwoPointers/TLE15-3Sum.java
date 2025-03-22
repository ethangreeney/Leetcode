// question link: https://leetcode.com/problems/3sum/

package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            var res = new HashMap<Integer, Integer>();

            for (int j = i + 1; j < nums.length; j++) {

                if (res.containsKey(-nums[i] - nums[j])) {

                    if (!output.contains(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]))) {

                        output.add(Arrays.asList(nums[i], nums[j], -nums[i] - nums[j]));

                    }

                } else {

                    res.put(nums[j], j);

                }
            }

        }

        return output;

    }
}