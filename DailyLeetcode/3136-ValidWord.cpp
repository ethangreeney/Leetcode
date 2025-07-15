// problem link: https://leetcode.com/problems/valid-word/description

#include <string>

class Solution {  // 0ms beats 100%
 public:
  bool isValid(std::string word) {
    if (word.size() < 3) {
      return false;
    }

    int vowel_count = 0;
    int consonant_count = 0;

    for (const char c : word) {
      if (std::tolower(c) == 'a' || std::tolower(c) == 'e' ||
          std::tolower(c) == 'i' || std::tolower(c) == 'o' ||
          std::tolower(c) == 'u') {
        ++vowel_count;
      } else if (std::isalpha(c)) {
        ++consonant_count;
      } else if (!std::isalnum(c)) {
        return false;
      }
    }
    return vowel_count && consonant_count;
  }
};