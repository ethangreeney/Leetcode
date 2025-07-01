#include <unordered_map>
#include <vector>

class Solution {
 public:
  int findLHS(std::vector<int> &nums) {
    if (nums.size() == 1) {
      return 0;
    }

    std::unordered_map<int, int> freq;

    for (int i : nums) {
      freq[i]++;
    }

    int maxSub = 0;

    for (const auto &[key, value] : freq) {
      if (freq.count(key - 1)) {
        maxSub = std::max(maxSub, freq[key] + freq[key - 1]);
      }
    }

    return maxSub;
  }
};