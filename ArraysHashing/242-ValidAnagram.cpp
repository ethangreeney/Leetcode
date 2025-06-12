// problem link: https://leetcode.com/problems/valid-anagram/description/

#include <string>
#include <vector>

class Solution { // 0ms beats 100%
 public:
  bool isAnagram(std::string s, std::string t) {

    if (s.length() != t.length()) {
      return false;
    }

    int charFreq[26] = {}; // C style array for stack allocation

    for (int i = 0; i < s.length(); i++) {
        charFreq[s[i] - 'a']++;
        charFreq[t[i] - 'a']--;
    }
    
    for(int i : charFreq){
      if (i != 0){return false;}
    }
    return true;
    
}
};