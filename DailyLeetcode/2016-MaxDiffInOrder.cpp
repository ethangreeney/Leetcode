// problem link:
// https://leetcode.com/problems/maximum-difference-between-increasing-elements/

#include <vector>

class Solution {  // 0ms beats 100%
 public:
  int maximumDifference(std::vector<int>& nums) {
    if (nums.size() < 2) {
      return -1;
    }

    int maxDiff = nums[1] - nums[0];
    int minSoFar = nums[0];

    for (int i = 0; i < nums.size(); i++) {
      minSoFar = std::min(nums[i], minSoFar);
      maxDiff = std::max(maxDiff, nums[i] - minSoFar);
    }

    return maxDiff < 1 ? -1 : maxDiff;
  }
};