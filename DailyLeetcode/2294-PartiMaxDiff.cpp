// problem link:
// https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/description/

#include <vector>

class Solution {  // 33ms beats 70%
 public:
  int partitionArray(std::vector<int>& nums, int k) {
    std::sort(nums.begin(), nums.end());

    int current = nums[0];

    int numberOfPartitions = 1;

    for (int i = 1; i < nums.size(); i++) {
      if (nums[i] - current > k) {
        current = nums[i];
        numberOfPartitions++;
      }
    }

    return numberOfPartitions;
  }
};