// problem link:
// https://leetcode.com/problems/longest-harmonious-subsequence/description/

#include <unordered_map>
#include <vector>

class OptimisedSolution {  // 16ms beats 68%
 public:
  int findLHS(std::vector<int>& nums) {
    if (nums.size() == 1) {
      return 0;
    }

    std::unordered_map<int, int> freq;

    for (int i : nums) {
      freq[i]++;
    }

    int maxSub = 0;

    for (const auto& [key, value] : freq) {
      if (freq.count(key - 1)) {
        maxSub = std::max(maxSub, value + freq[key - 1]);
      }
    }
    return maxSub;
  }
};

class NaiveSolution {  // 35ms beats 34%
 public:
  int findLHS(std::vector<int>& nums) {
    if (nums.size() == 1) {
      return 0;
    }

    std::unordered_map<int, int> freq;

    for (int i : nums) {
      freq[i]++;
    }

    std::vector<std::pair<int, int>> entrySet;

    for (const std::pair<int, int> pair : freq) {
      entrySet.push_back(pair);
    }

    std::sort(entrySet.begin(), entrySet.end());

    int maxSub = 0;

    for (int i = 0; i < entrySet.size() - 1; i++) {
      if (entrySet[i + 1].first - entrySet[i].first == 1) {
        maxSub = std::max(maxSub, entrySet[i + 1].second + entrySet[i].second);
      }
    }
    return maxSub;
  }
};