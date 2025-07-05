// problem link: https://leetcode.com/problems/counting-bits

#include <vector>

class Solution {
 public:
  std::vector<int> countBits(int n) {  // 0ms beats 100%
    std::vector<int> res;
    res.reserve(n + 1);

    res.push_back(0);

    for (int i = 1; i <= n; ++i) {
      int total_bits = 0;
      int number = i;

      while (number) {
        total_bits += number & 1;
        number >>= 1;
      }

      res.push_back(total_bits);
    }

    return res;
  }
};