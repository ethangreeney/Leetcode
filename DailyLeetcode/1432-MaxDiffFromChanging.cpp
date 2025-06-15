// problem link:
// https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/

#include <vector>

class Solution {
 public:
  int maxDiff(int num) {  // 0ms beats 100%
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
    bool seenOne = false;
    char map;
    bool flag = false;

    for (int i = 0; i < minNum.length(); i++) {
      if (!found) {
        if (minNum[i] == '1') {
          flag = true;
        }
        if (seenOne) {
          if (minNum[i] != '1' && minNum[i] != '0') {
            firstAboveZero = minNum[i];
            map = '0';
            minNum[i] = map;
            found = true;
          }
        } else {
          if (minNum[i] != '0' && minNum[i] != '1') {
            firstAboveZero = minNum[i];
            map = '1';
            minNum[i] = map;
            found = true;
          }
        }
        seenOne = flag;
      } else {
        if (minNum[i] == firstAboveZero) {
          minNum[i] = map;
        }
      }
    }
    int min = std::stoi(minNum);

    return min == 0 ? max - num : max - min;
  }
};