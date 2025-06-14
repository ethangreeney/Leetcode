// problem link:
// https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/

#include <vector>

class Solution {  // 0ms beats 100%
 public:
  int minMaxDifference(int num) {
    std::string maxNum = std::to_string(num);

    char firstBelowNine;
    bool found = false;

    for (int i = 0; i < maxNum.length(); i++) {
      if (!found) {
        if (maxNum[i] != '9') {
          firstBelowNine = maxNum[i];
          maxNum[i] = '9';
          found = true;
        }
      } else {
        if (maxNum[i] == firstBelowNine) {
          maxNum[i] = '9';
        }
      }
    }

    int max = std::stoi(maxNum);

    std::string minNum = std::to_string(num);
    char firstAboveZero;
    found = false;

    for (int i = 0; i < minNum.length(); i++) {
      if (!found) {
        if (minNum[i] != '0') {
          firstAboveZero = minNum[i];
          minNum[i] = '0';
          found = true;
        }
      } else {
        if (minNum[i] == firstAboveZero) {
          minNum[i] = '0';
        }
      }
    }

    int min = std::stoi(minNum);

    return max - min;
  }
};