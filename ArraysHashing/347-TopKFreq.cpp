// problem link: https://leetcode.com/problems/top-k-frequent-elements/

#include <unordered_map>
#include <vector>

class Solution {  // 0ms beats 100%
 public:
  std::vector<int> topKFrequent(std::vector<int>& nums, int k) {
    std::unordered_map<int, int> freq;
    freq.reserve(nums.size());

    for (int i : nums) {
      freq[i]++;
    }

    std::vector<std::vector<int>> bucketSort(nums.size() + 1);

    for (const auto& [key, value] : freq) {
      bucketSort[value].push_back(key);
    }

    std::vector<int> res;
    res.reserve(k);

    for (int i = bucketSort.size() - 1; i >= 0; i--) {
      auto& currentBucket = bucketSort[i];
      for (const auto& entry : currentBucket) {
        if (!k) {
          return res;
        }
        res.push_back(entry);
        k--;
      }
    }
    return res;
  }
};