// problem link: https://leetcode.com/problems/finding-pairs-with-a-certain-sum

#include <unordered_map>
#include <vector>

class FindSumPairs {  // 81ms Beats 76.83 %
 public:
  std::vector<int> nums1;
  std::vector<int> nums2;

  std::unordered_map<int, int> nums2_freq;

  FindSumPairs(std::vector<int>& nums1, std::vector<int>& nums2)
      : nums1(nums1), nums2(nums2) {
    nums2_freq.reserve(nums2.size());

    for (const int& i : nums2) {
      ++nums2_freq[i];
    }
  }

  void add(int index, int val) {
    --nums2_freq[nums2[index]];
    ++nums2_freq[nums2[index] + val];
    nums2[index] += val;
  }

  int count(int tot) {
    int count = 0;

    for (const int& i : nums1) {
      int complement = tot - i;
      if (nums2_freq.count(complement)) {
        count += nums2_freq[complement];
      }
    }

    return count;
  }
};