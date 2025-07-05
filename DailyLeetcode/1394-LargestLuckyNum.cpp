// problem link: https://leetcode.com/problems/find-lucky-integer-in-an-array

#include <array>
#include <vector>

class Solution {  // 0ms beats 100%
 public:
  int findLucky(std::vector<int>& arr) {
    std::array<int, 501> freq = {};  // list initialisation

    for (const int& i : arr) {  // trade offs for doing int vs int&
      ++freq[i];
    }

    for (size_t i = 500; i > 0; --i) {
      if (freq[i] == i) {
        return i;
      }
    }
    return -1;
  }
};