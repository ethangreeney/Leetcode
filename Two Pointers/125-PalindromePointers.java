/**
 * <a href="https://leetcode.com/problems/valid-palindrome/">Valid
 * Palindrome</a>
 */

class Solution {
    public boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        for (; l < r; l++, r--) {
            while (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            }
        }

        return true;

    }
}