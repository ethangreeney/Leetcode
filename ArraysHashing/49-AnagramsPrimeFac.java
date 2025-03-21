// problem link: https://leetcode.com/problems/group-anagrams/description/

package ArraysHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    final int[] primes = new int[] { 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
            83, 89, 97, 101, 103 };

    public List<List<String>> groupAnagrams(String[] strs) {

        var freq = new HashMap<Integer, List<String>>();
        var res = new ArrayList<List<String>>();

        for (String s : strs) {

            int key = 1;

            for (char c : s.toCharArray()) {
                key *= primes[c - 'a'];
            }

            if (!freq.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                res.add(list);
                freq.put(key, list);
            } else {
                freq.get(key).add(s);
            }

        }
        return res;

    }
}
