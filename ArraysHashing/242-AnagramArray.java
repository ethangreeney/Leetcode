// problem link https://leetcode.com/problems/valid-anagram/description/

package ArraysHashing;

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        var res = new int[26];

        for (char c : s.toCharArray()) {
            res[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            res[c - 'a']--;
        }

        for (int i : res) {
            if (i != 0) {
                return false;
            }
        }

        return true;

    }
}