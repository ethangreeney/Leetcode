// problem link: https://leetcode.com/problems/3sum/

package TwoPointers;

import java.util.ArrayList;
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

class ImprovedPointerLogic {// 22ms beats 99.64%
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for (int i = 2; i < nums.length; i++) {
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }

            int l = 0;
            int r = i - 1;

            while (l < r) {

                while (nums[l] + nums[r] + nums[i] < 0 && l < r) {
                    l++;
                }
                while (nums[l] + nums[r] + nums[i] > 0 && r > l) {
                    r--;
                }

                if (r > l && nums[l] + nums[r] + nums[i] == 0) {
                    result.add(Arrays.asList(nums[l], nums[r], nums[i]));

                    while (l < r && nums[l] == nums[l + 1])
                        l++;
                    while (l < r && nums[r] == nums[r - 1])
                        r--;
                    r--;
                    l++;
                }
            }

        }

        return result;

    }
}