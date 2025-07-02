// problem link: https://leetcode.com/problems/contains-duplicate/

#include <unordered_set>

class Solution {  // 43ms beats 74% (best O(n) time possible)
 public:
  bool containsDuplicate(std::vector<int>& nums) {
    std::unordered_set<int> hashSet;
    hashSet.reserve(nums.size());

    for (int i : nums) {
      if (!hashSet.insert(i).second) {
        return true;
      }
    }
    return false;
  }
};