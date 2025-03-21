// problem link https://leetcode.com/problems/top-k-frequent-elements/description/

package ArraysHashing;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int max = nums[0];
        int min = nums[0];

        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        var freq = new int[max - min + 1];
        @SuppressWarnings("unchecked")
        List<Integer>[] res = new ArrayList[nums.length + 1];
        var output = new int[k];

        for (int i : nums) {
            freq[i - min]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (res[freq[i]] == null) {
                res[freq[i]] = new ArrayList<>();
            }
            res[freq[i]].add(i + min);
        }

        int freqCount = 0;

        for (int i = nums.length; i > 0; i--) {
            if (res[i] == null) {
                continue;
            }
            for (var entry : res[i].toArray()) {
                if (freqCount < k) {
                    output[freqCount++] = (int) entry;
                }
            }
            if (freqCount == k) {
                break;
            }

        }
        return output;

    }
}