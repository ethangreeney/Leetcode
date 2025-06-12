// problem link: https://leetcode.com/problems/valid-anagram/description/

#include <string>
#include <vector>

class Solution {
 public:
  bool isAnagram(std::string s, std::string t) {

    if (s.length() != t.length()) {
      return false;
    }

    std::vector<int> charFreq(26,0);

    for (int i = 0; i < s.length(); i++) {
        charFreq[s[i]%26]++;
        charFreq[t[i]%26]--;
    }
    
    for(int i : charFreq){
      if (i != 0){return false;}
    }
    return true;
    
}
};