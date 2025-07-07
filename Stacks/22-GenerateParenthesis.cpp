// problem link: https://leetcode.com/problems/generate-parentheses/

// passing the string by reference was far more efficient than passing by value.
// Passing the current string by value with + made is so a full copy of the
// string had to be made every time, degrading performance significantly.

#include <string>
#include <vector>

class Solution {  // 0ms beats 100%
 public:
  std::vector<std::string> generateParenthesis(int n) {
    std::vector<std::string> res;
    std::string res_so_far = "";
    backtrack(res, res_so_far, n, n);
    return res;
  }

 private:
  void backtrack(std::vector<std::string>& result, std::string& current_string,
                 int rem_open, int rem_closed) {
    if (rem_closed == 0 && rem_open == 0) {
      result.push_back(current_string);
      return;
    }
    if (rem_open > 0) {
      backtrack(result, current_string += '(', rem_open - 1, rem_closed);
      current_string.pop_back();
    }
    if (rem_open < rem_closed) {
      backtrack(result, current_string += ')', rem_open, rem_closed - 1);
      current_string.pop_back();
    }
  }
};

class Solution {  // 5ms beats 20%
 public:
  std::vector<std::string> generateParenthesis(int n) {
    std::vector<std::string> res;
    backtrack(res, "", n, n);
    return res;
  }

 private:
  void backtrack(std::vector<std::string>& result, std::string current_string,
                 int rem_open, int rem_closed) {
    if (rem_closed == 0 && rem_open == 0) {
      result.push_back(current_string);
      return;
    }
    if (rem_open > 0) {
      backtrack(result, current_string + '(', rem_open - 1, rem_closed);
    }
    if (rem_open < rem_closed) {
      backtrack(result, current_string + ')', rem_open, rem_closed - 1);
    }
  }
};