// problem link: https://leetcode.com/problems/climbing-stairs/

#include <vector>

class Solution {  // 0ms beats 100%
 public:
  int climbStairs(int n) {
    if (n < 3) {
      return n;
    }

    int firstStair = 1;
    int secondStair = 2;
    int total = 3;

    for (int i = 3; i < n; i++) {
      firstStair = secondStair;
      secondStair = total;
      total = firstStair + secondStair;
    }

    return total;
  }
};