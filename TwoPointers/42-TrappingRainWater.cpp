// problem link: https://leetcode.com/problems/trapping-rain-water/description/

#include <vector>

class Solution {  // 0ms beats 100%
 public:
  int trap(std::vector<int>& height) {
    int l = 0;
    int r = height.size() - 1;

    int maxL = 0;
    int maxR = 0;

    int totalWater = 0;

    while (l <= r) {
      if (maxL < maxR) {
        if (height[l] < maxL) {
          totalWater += maxL - height[l];
        }
        maxL = std::max(maxL, height[l]);
        ++l;
      } else {
        if (height[r] < maxR) {
          totalWater += maxR - height[r];
        }
        maxR = std::max(maxR, height[r]);
        --r;
      }
    }

    return totalWater;
  }
};

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