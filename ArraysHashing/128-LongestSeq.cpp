// problem link: https://leetcode.com/problems/longest-consecutive-sequence/

#include <unordered_set>

class Solution {  // 78ms beats 71%
 public:
  int longestConsecutive(std::vector<int>& nums) {
    std::unordered_set<int> numsSet;

    for (int i : nums) {
      numsSet.insert(i);
    }

    int maxSeq = 0;
    int seq;

    for (int i : numsSet) {
      seq = 0;
      if (!numsSet.count(--i)) {
        while (numsSet.count(++i)) {
          seq++;
        }
      }
      maxSeq = std::max(maxSeq, seq);
    }
    return maxSeq;
  }
};