// problem link:
// https://leetcode.com/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/

#include <vector>

class Solution {  // 0ms beats 100%
 public:
  int countGoodArrays(int n, int m, int k) {
    long long result =
        ((((fact[FACTORIAL][n - 1] * fact[INVERSE_FACTORIAL][k]) % MOD *
           fact[INVERSE_FACTORIAL][n - k - 1]) %
          MOD) *
         m % MOD) *
        binPow(m - 1, n - 1 - k);
    return result % MOD;
  }
  static int binPow(long long base, int exponent) {
    long long result = 1;

    while (exponent) {
      if (exponent & 1) {
        result = (result * base) % MOD;
      }
      base = ((base % MOD) * (base % MOD)) % MOD;
      exponent >>= 1;
    }

    return result;
  }
  static const int MOD = 1e9 + 7;
  static const int upperBound = 100000;

  static const int FACTORIAL = 0;
  static const int INVERSE_FACTORIAL = 1;

  inline static std::vector<std::vector<long long>> fact = [] {
    std::vector<std::vector<long long>> factorial(2);
    factorial[0].resize(upperBound + 1);
    factorial[1].resize(upperBound + 1);

    factorial[FACTORIAL][0] = 1;
    for (int i = 1; i <= upperBound; i++) {
      factorial[FACTORIAL][i] = (factorial[FACTORIAL][i - 1] * i) % MOD;
    }

    factorial[INVERSE_FACTORIAL][upperBound] =
        binPow(factorial[FACTORIAL][upperBound], MOD - 2);

    for (int i = upperBound - 1; i >= 0; --i) {
      factorial[INVERSE_FACTORIAL][i] =
          (factorial[INVERSE_FACTORIAL][i + 1] * (i + 1)) % MOD;
    }
    return factorial;
  }();
};

class Solution {  // 0ms beats 100%
 public:
  class preCompute {
   public:
    static constexpr int nBound = 100001;
    static constexpr int MOD = 1e9 + 7;

    std::vector<long long> fact;
    std::vector<long long> invFact;

    preCompute() : fact(nBound), invFact(nBound) {
      fact[0] = 1;

      for (int i = 1; i < nBound; i++) {
        fact[i] = (fact[i - 1] * i) % MOD;
      }

      invFact[nBound - 1] = ModBinExp(fact[nBound - 1], MOD - 2);

      for (int i = nBound - 2; i >= 0; i--) {
        invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
      }
    }

    long long ModBinExp(long long base, long long exponent) {
      long long result = 1;
      base %= MOD;

      while (exponent) {
        if ((exponent & 1) == 1) {
          result = (result * base) % MOD;
        }
        base = ((base % MOD) * (base % MOD)) % MOD;
        exponent >>= 1;
      }
      return result;
    }

    long long combinations(int n, int k) {
      return ((fact[n] * invFact[n - k]) % MOD) * invFact[k] % MOD;
    }
  };
  static preCompute compute;

  int countGoodArrays(int n, int m, int k) {
    int noOfArragments = compute.combinations(n - 1, k);
    long long numberOfColourings =
        (m * compute.ModBinExp(m - 1, n - 1 - k)) % compute.MOD;

    return noOfArragments * numberOfColourings % compute.MOD;
  }
};
Solution::preCompute Solution::compute;