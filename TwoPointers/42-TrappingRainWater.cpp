// problem link: https://leetcode.com/problems/trapping-rain-water/description/

#include <vector>

class Solution {  // only works for one test case
 public:
  int trap(std::vector<int>& height) {
    int total_water = 0;

    for (int left = 0; left < height.size(); left++) {
      int right = left + 1;

      while (height[right] < height[left]) {
        if (right == height.size()) {
          right = left + 1;
          break;
        }
        right++;
      }

      total_water += right - left - 1;
    }
    return total_water;
  }
};