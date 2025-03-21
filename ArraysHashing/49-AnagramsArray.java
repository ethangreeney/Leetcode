// problem link: https://leetcode.com/problems/group-anagrams/description/

package ArraysHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<List<String>> groupAnagrams(String[] strings) {

        Map<String, List<String>> map = new HashMap<>();

        for (String string : strings) {

            char[] count = new char[26];

            for (char c : string.toCharArray()) {
                count[c - 'a']++;
            }

            String key = new String(count);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(string);

        }
        return new ArrayList<>(map.values());
    }
}
