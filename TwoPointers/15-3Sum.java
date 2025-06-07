// problem link: https://leetcode.com/problems/3sum/

package TwoPointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FisrtSolution { // 1498ms beats 5%
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> result = new HashSet<List<Integer>>();

        Arrays.sort(nums);

        for (int i = 2; i < nums.length; i++) {

            int l = 0;

            for (int r = 1; r < i; r++) {
                while (nums[l] + nums[r] + nums[i] < 0 && l < r - 1) {
                    l++;
                }
                while (nums[l] + nums[r] + nums[i] > 0 && l > 0) {
                    l--;
                }

                if (nums[l] + nums[r] + nums[i] == 0) {
                    result.add(Arrays.asList(nums[l], nums[r], nums[i]));
                }
            }

        }

        return result.stream().toList();

    }
}