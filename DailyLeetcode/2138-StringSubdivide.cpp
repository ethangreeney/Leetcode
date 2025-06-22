// problem link:
// https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/

#include <vector>

class Solution {
 public:
  std::vector<std::string> divideString(std::string s, int k,
                                        char fill) {  // 0ms beats 100%
    s.reserve((s.size() / k) * k);

    for (int i = s.size(); s.size() % k; i++) {
      s += fill;
    }

    std::vector<std::string> result;
    result.reserve(s.capacity() / k);

    for (int i = 0; i <= s.size() - k; i++) {
      if (i % k == 0) {
        std::string currentPartition;
        currentPartition.reserve(k);
        for (int x = i; x < i + k; x++) {
          currentPartition += s[x];
        }
        result.push_back(currentPartition);
      }
    }

    return result;
  }
};