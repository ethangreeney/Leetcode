// problem link: https://leetcode.com/problems/3sum/

#include <algorithm>
#include <vector>
// 35ms beats 98%
std::vector<std::vector<int>> threeSum(std::vector<int>& nums) {
  std::sort(nums.begin(), nums.end());
  std::vector<std::vector<int>> outputArray;

  for (int i = 2; i < nums.size(); i++) {
    while (i < nums.size() - 1 && nums[i] == nums[i + 1]) {
      i++;
    }
    for (int l = 0, r = i - 1; l < r;) {
      while (nums[l] + nums[r] + nums[i] > 0 && r > l) {
        r--;
      }
      while (nums[l] + nums[r] + nums[i] < 0 && r > l) {
        l++;
      }

      if (l < r && nums[l] + nums[r] + nums[i] == 0) {
        outputArray.emplace_back(std::vector<int>{nums[l], nums[r], nums[i]});
        while (l < r && nums[l] == nums[l + 1]) {
          l++;
        }
        while (l < r && nums[r] == nums[r - 1]) {
          r--;
        }
        r--;
        l++;
      }
    }
  }

  return outputArray;
}