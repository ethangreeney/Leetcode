// problem link:
// https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum

#include <algorithm>
#include <unordered_map>
#include <vector>

class Solution {
 public:
  std::vector<int> maxSubsequence(std::vector<int>& nums, int k) {
    std::vector<int> originalNums = nums;

    std::sort(nums.begin(), nums.end());
    std::unordered_map<int, int> topKFreq;
    int n = nums.size();
    for (int i = n - 1; i >= n - k; i--) {
      topKFreq[nums[i]]++;
    }
    std::vector<int> res;
    res.reserve(k);
    for (int i : originalNums) {
      if (topKFreq[i]-- > 0) {
        res.push_back(i);
      }
    }
    return res;
  }
};