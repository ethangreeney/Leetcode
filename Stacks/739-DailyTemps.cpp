// problem link: https://leetcode.com/problems/daily-temperatures

#include <stack>
#include <vector>

class Solution {  // 7ms beats 98%
 public:
  std::vector<int> dailyTemperatures(std::vector<int>& temperatures) {
    int n = temperatures.size();
    std::stack<int> stack;
    std::vector<int> res(n);

    for (int i = n - 1; i >= 0; --i) {
      while (!stack.empty() and temperatures[stack.top()] <= temperatures[i]) {
        stack.pop();
      }
      if (!stack.empty()) {
        res[i] = stack.top() - i;
      }
      stack.push(i);
    }
    return res;
  }
};

class Solution {  // 20ms beats 67%
 public:
  std::vector<int> dailyTemperatures(std::vector<int>& temperatures) {
    int n = temperatures.size();
    std::stack<int> stack;
    std::vector<int> res(n);

    for (size_t i = 0; i < n; ++i) {
      while (!stack.empty() and temperatures[stack.top()] < temperatures[i]) {
        size_t top_index = stack.top();
        res[top_index] = i - top_index;
        stack.pop();
      }
      stack.push(i);
    }
    return res;
  }
};