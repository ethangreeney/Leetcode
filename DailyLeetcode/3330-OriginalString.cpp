// problem link: https://leetcode.com/problems/find-the-original-typed-string-i

#include <array>
#include <string>

class Solution {  // 0ms beats 100%
 public:
  int possibleStringCount(std::string word) {
    int sum = 1;

    for (int i = 0; i < word.size() - 1; i++) {
      if (word[i] == word[i + 1]) sum++;
    }

    return sum;
  }
};