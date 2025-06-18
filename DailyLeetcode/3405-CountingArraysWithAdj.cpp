// problem link:
// https://leetcode.com/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/

#include <vector>

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