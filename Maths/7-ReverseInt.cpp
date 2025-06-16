// problem link: https://leetcode.com/problems/reverse-integer/

#include <cmath>

class Solution {  // 2ms beats 38%
 public:
  int reverse(const int x) {
    if (x == 0) {
      return 0;
    }

    int positiveOrNegavtive = x < 0 ? -1 : 1;

    long toReverse = std::abs((long)x);
    long xReversed = 0;

    while (toReverse > 0) {
      int digitToAdd = toReverse % 10;
      xReversed *= 10;
      xReversed += digitToAdd;
      toReverse /= 10;
    }

    xReversed *= positiveOrNegavtive;

    int toReturn =
        xReversed < INT32_MIN || xReversed > INT32_MAX ? 0 : xReversed;

    return toReturn;
  }
};