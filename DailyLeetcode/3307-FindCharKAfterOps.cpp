// problem link:
// https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii

#include <string>
#include <vector>

class Solution {  // tle
 public:
  char kthCharacter(long long k, std::vector<int>& operations) {
    std::string word = "a";

    for (int operation : operations) {
      std::string wordToAdd;

      if (operation == 0) {
        wordToAdd = word;
      } else {
        for (char c : word) {
          wordToAdd += ('a' + ((c - 'a' + 1) % 26));
        }
      }

      word += wordToAdd;

      if (word.size() > k) {
        break;
      }
    }

    return word[k - 1];
  }
};