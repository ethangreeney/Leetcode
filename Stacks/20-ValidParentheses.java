// problem link: https://leetcode.com/problems/valid-parentheses/description/

package Stacks;

class Solution {
    public boolean isValid(String s) {

        char[] stack = new char[s.length() + 1];
        int index = -1;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                stack[++index] = ')';
            } else if (c == '{') {
                stack[++index] = '}';
            } else if (c == '[') {
                stack[++index] = ']';
            } else if (index == -1 || stack[index--] != c) {
                return false;
            }

        }

        return index == -1;

    }
}