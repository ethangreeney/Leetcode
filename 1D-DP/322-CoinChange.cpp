// problem link: https://leetcode.com/problems/coin-change/

#include <vector>

class SolutionBetterCacheLocality {  // 11ms beats 98%
 public:
  int coinChange(std::vector<int>& coins, int amount) {
    std::vector<int> DP(amount + 1, amount + 1);

    DP[0] = 0;

    for (const auto& coin : coins) {
      for (int i = coin; i <= amount; i++) {
        DP[i] = std::min(DP[i], DP[i - coin] + 1);
      }
    }
    return DP[amount] == amount + 1 ? -1 : DP[amount];
  }
};

class Solution {  // 11ms beats 98%
 public:
  int coinChange(std::vector<int>& coins, int amount) {
    std::vector<int> DP(amount + 1, INT_MAX);

    DP[0] = 0;

    for (int i = 0; i <= amount; i++) {
      if (DP[i] == INT_MAX) {
        continue;
      }
      for (const auto& coin : coins) {
        if (coin <= amount - i) {
          DP[i + coin] = std::min(DP[i + coin], DP[i] + 1);
        }
      }
    }

    return DP[amount] == INT_MAX ? -1 : DP[amount];
  }
};