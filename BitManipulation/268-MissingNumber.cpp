// problem link: https://leetcode.com/problems/missing-number

#include <vector>

class Solution {  // 0ms beats 100%
 public:
  int missingNumber(std::vector<int>& nums) {
    std::vector<bool> range(nums.size());

    for (int i : nums) {
      range[i] = true;
    }
    size_t i = 0;
    for (; i < range.size(); ++i) {
      if (!range[i]) {
        return i;
      }
    }
    return i;
  }
};