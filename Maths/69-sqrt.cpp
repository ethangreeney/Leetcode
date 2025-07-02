// problem link: https://leetcode.com/problems/sqrtx

class Solution {
 public:
  int mySqrt(int x) {  // 10ms beats 14%
    int i;
    for (i = 1; (long)i * i <= x; i++) {
    }
    return i - 1;
  }
};