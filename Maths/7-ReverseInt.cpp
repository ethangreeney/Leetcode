// problem link: https://leetcode.com/problems/reverse-integer/

#include <climits>
#include <cmath>

class Solution {  // 2ms beats 38%
 public:
  int naiveSolution(const int x) {
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

class OptimisedSolution {  // 0ms beats 100%
  int reverseOptimised(int x) {
    int reversed = 0;
    while (x) {
      int lastDigit = x % 10;
      if (reversed > INT_MAX / 10 || reversed < INT_MIN / 10) {
        return 0;
      }
      reversed = reversed * 10 + lastDigit;
      x /= 10;
    }
    return reversed;
  }
};