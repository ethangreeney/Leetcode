// problem link:
// https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes

#include <array>
#include <string>

class Solution {  // 54ms beats 88%
 public:
  int maxDistance(std::string s, int k) {
    int north = 0, east = 0, south = 0, west = 0;

    int maxDistance = 0, currentDistance = 0, wastefulMoves = 0;

    for (char c : s) {
      if (c == 'N') north++;
      if (c == 'E') east++;
      if (c == 'S') south++;
      if (c == 'W') west++;
      currentDistance = std::abs(north - south) + std::abs(east - west);
      wastefulMoves = std::min(north, south) + std::min(east, west);
      wastefulMoves = std::min(2 * wastefulMoves, 2 * k);
      maxDistance = std::max(maxDistance, currentDistance + wastefulMoves);
    }

    return maxDistance;
  }
};