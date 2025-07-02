// problem link: https://leetcode.com/problems/coin-change/

#include <vector>

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