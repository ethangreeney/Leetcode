// problem link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

package SlidingWindow;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() < 2) {
            return s.length();
        }

        int[] freq = new int[128];

        int maxLen = 0;

        int l = 0;
        freq[s.charAt(l)]++;

        for (int r = 1; r < s.length(); r++) {

            freq[s.charAt(r)]++;

            while (freq[s.charAt(r)] > 1) {
                freq[s.charAt(l++)]--;
            }

            maxLen = Math.max(maxLen, r - l + 1);

        }

        return maxLen;

    }
}