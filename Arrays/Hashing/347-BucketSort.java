package Arrays.Hashing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class topKFrequent327 {
    public int[] topKFrequent(int[] nums, int k) {

        var freq = new HashMap<Integer, Integer>();

        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] res = new ArrayList[nums.length + 1];

        for (int key : freq.keySet()) {
            if (res[freq.get(key)] == null) {
                res[freq.get(key)] = new ArrayList<>();
            }
            res[freq.get(key)].add(key);
        }

        var output = new int[k];

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
                return output;
            }

        }
        return new int[] { 0, 0 };

    }
}