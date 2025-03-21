// problem link: https://leetcode.com/problems/group-anagrams/description/

package ArraysHashing;

class Solution {

    public final int[] primes = new int[] { 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
            71, 73, 79, 83, 89, 97, 101, 103 };

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int sKey = 1;
        int tKey = 1;

        for (char c : s.toCharArray()) {
            sKey *= primes[c - 'a'];
        }
        for (char c : t.toCharArray()) {
            tKey *= primes[c - 'a'];
        }
        return sKey == tKey;

    }
}