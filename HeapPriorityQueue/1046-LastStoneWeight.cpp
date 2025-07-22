// problem link: https://leetcode.com/problems/last-stone-weight

#include <queue>
#include <vector>

class Solution {  // 0ms beats 100%
 public:
  int lastStoneWeight(std::vector<int>& stones) {
    std::priority_queue<int> maxHeap(
        stones.begin(),
        stones.end());  // more idiomatic heap construction using the max heaps
                        // range based constructor. Can also be more performant
                        // as a heapify alg is used over one by one inserts

    while (maxHeap.size() > 1) {
      int big_stone = maxHeap.top();
      maxHeap.pop();
      int small_stone = maxHeap.top();
      maxHeap.pop();

      if (big_stone > small_stone) {
        maxHeap.emplace(
            big_stone -
            small_stone);  // use emplace where possible to create the object in
                           // place, rather than potentially make a temp object
                           // that is not useful
      }
    }

    return maxHeap.empty() ? 0 : maxHeap.top();
  }
};

class Solution {  // 0ms beats 100%
 public:
  int lastStoneWeight(std::vector<int>& stones) {
    std::priority_queue<int> maxHeap;

    for (const int stone : stones) {
      maxHeap.push(stone);
    }

    while (maxHeap.size() > 1) {
      int big_stone = maxHeap.top();
      maxHeap.pop();
      int small_stone = maxHeap.top();
      maxHeap.pop();

      if (big_stone != small_stone) {
        maxHeap.push(big_stone - small_stone);
      }
    }

    return maxHeap.empty() ? 0 : maxHeap.top();
  }
};