// problem link:
// https://leetcode.com/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/

#include <vector>

class Solution {  // 49ms beats 56%
 public:
  std::vector<std::vector<int>> divideArray(std::vector<int>& nums, int k) {
        std::sort(nums.begin(), nums.end());
    std::vector<std::vector<int>> result;

    for (int i = 0; i < nums.size() - 2; i += 3) {
      if (nums[i + 2] - nums[i] <= k) {
        result.push_back({nums[i], nums[i + 1], nums[i + 2]});
      } else {
        return {};
      }
    }
    return result;
  }
};