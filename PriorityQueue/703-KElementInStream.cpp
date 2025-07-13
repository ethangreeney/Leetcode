// problem link: https://leetcode.com/problems/kth-largest-element-in-a-stream

#include <queue>
#include <vector>

class KthLargest {  // 6ms beats 68%
 public:
  std::priority_queue<int, std::vector<int>, std::greater<int>> queue;
  int k;

  KthLargest(int k, std::vector<int>& nums) : k(k) {
    for (int i : nums) {
      add(i);
    }
  }

  int add(int val) {
    queue.push(val);
    if (queue.size() > k) queue.pop();
    return queue.top();
  }
};
