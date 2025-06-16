// problem link: https://leetcode.com/problems/two-sum/solutions/127810/two-sum/

#include <unordered_map>
#include <vector>

class Solution {  // 2m beats 76%
 public:
  std::vector<int> twoSum(std::vector<int>& nums, int target) {
    std::unordered_map<int, int> map;

    for (int i = 0; i < nums.size(); i++) {
      if (map.count(target - nums[i]) > 0) {
        return {map[target - nums[i]], i};
      }
      map[nums[i]] = i;
    }

    return {-1, -1};
  }
};