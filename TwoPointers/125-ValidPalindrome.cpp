// problem link: https://leetcode.com/problems/valid-palindrome/

#include <string>
class Solution {  // 3ms beats 31%
 public:
  bool isPalindrome(std::string s) {
    int low = 0;
    int high = s.length() - 1;

    while (low < high) {
      while (low < high && !isalnum(s[low])) {
        low++;
      }
      while (low < high && !isalnum(s[high])) {
        high--;
      }

      if (tolower(s[low]) != tolower(s[high])) {
        return false;
      }
      low++, high--;
    }
    return true;
  }
};