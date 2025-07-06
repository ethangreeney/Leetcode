// problem link: https://leetcode.com/problems/finding-pairs-with-a-certain-sum

#include <unordered_map>
#include <vector>

class FindSumPairs {  // 8ms Beats 77.63 %
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
      auto complement = nums2_freq.find(tot - i);
      if (complement != nums2_freq.end()) {
        count += complement->second;
      }
    }

    return count;
  }
};