// problem link: https://leetcode.com/problems/search-a-2d-matrix/

#include <vector>

class Solution {  // 0ms beats 100%
 public:
  bool searchMatrix(std::vector<std::vector<int>>& matrix, int target) {
    int left = 0;
    int right = matrix.size() * matrix[0].size() - 1;
    int size = matrix[0].size();

    while (left <= right) {
      int middle = left + (right - left) / 2;

      int mid_val = matrix[middle / size][middle % size];

      if (target < mid_val) {
        right = middle - 1;
      } else if (target > mid_val) {
        left = middle + 1;
      } else {
        return true;
      }
    }
    return false;
  }
};