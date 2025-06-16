// problem link: https://leetcode.com/problems/two-sum/solutions/127810/two-sum/

#include <unordered_map>
#include <vector>

class Solution {  // 1ms beats 80%
 public:
  std::vector<int> twoSum(std::vector<int>& nums, int target) {
    std::unordered_map<int, int> map;
    map.reserve(nums.size());

    for (int i = 0; i < nums.size(); i++) {
      int complement = target - nums[i];
      auto it = map.find(complement);

      if (it != map.end()) {
        return {it->second, i};
      }
      map[nums[i]] = i;
    }
    return {};
  }
};