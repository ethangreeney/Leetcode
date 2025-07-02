// problem link: https://leetcode.com/problems/sqrtx

class OptimisedSolution {  // 0ms beats 100%
 public:
  int mySqrt(int x) {
    if (x == 0 || x == 1) {
      return x;
    }

    int l = 1;
    int r = x / 2;

    while (l <= r) {
      long m = l + (r - l) / 2;
      long mSquared = m * m;

      if (mSquared > x) {
        r = m - 1;
      } else if (mSquared < x) {
        l = m + 1;
      } else {
        return m;
      }
    }
    return r;
  }
};

class Solution {
 public:
  int mySqrt(int x) {  // 10ms beats 14%
    int i;
    for (i = 1; (long)i * i <= x; i++) {
    }
    return i - 1;
  }
};