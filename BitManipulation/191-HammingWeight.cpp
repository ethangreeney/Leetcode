// problem link: https://leetcode.com/problems/number-of-1-bits

class Solution {  // 0ms beats 100%
 public:
  int hammingWeight(int n) {
    if (n == 0) {
      return 0;
    }
    return (n & 1) + hammingWeight(n >>= 1);
  }
};