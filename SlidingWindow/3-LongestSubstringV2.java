// problem link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

package SlidingWindow;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[128];
        int maxLen = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {

            char ch = s.charAt(r);

            l = Math.max(l, freq[ch]);
            maxLen = Math.max(maxLen, r - l + 1);

            freq[ch] = r + 1;

        }

        return maxLen;

    }
}