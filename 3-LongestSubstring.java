// problem link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] charFreq = new int[128];
        char[] sArray = s.toCharArray();

        int l = 0;
        int r = 0;

        int maxLen = 0;

        for (; r < s.length(); r++) {

            charFreq[sArray[r]]++;

            while (charFreq[sArray[r]] > 1) {
                charFreq[sArray[l++]]--;
            }

            maxLen = Math.max(maxLen, r - l + 1);

        }

        return maxLen;
    }
}