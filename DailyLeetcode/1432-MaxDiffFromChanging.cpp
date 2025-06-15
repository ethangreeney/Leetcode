// problem link:
// https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/

#include <vector>

class CleanerSolution {
  int maxDiff(int num) {
    std::string numString = std::to_string(num);
    char charToReplace = ' ';

    for (char c : numString) {
      if (c != '9') {
        charToReplace = c;
        break;
      }
    }

    if (charToReplace != ' ') {
      std::replace(numString.begin(), numString.end(), charToReplace, '9');
    }

    int max = std::stoi(numString);

    numString = std::to_string(num);
    charToReplace = ' ';
    char replaceWith = ' ';

    if (numString[0] == '1') {
      for (char c : numString) {
        if (c != '0' && c != '1') {
          charToReplace = c;
          replaceWith = '0';
          break;
        }
      }
    } else {
      charToReplace = numString[0];
      replaceWith = '1';
    }

    if (charToReplace != ' ') {
      std::replace(numString.begin(), numString.end(), charToReplace,
                   replaceWith);
    }

    int min = std::stoi(numString);

    return max - min;
  }
};

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