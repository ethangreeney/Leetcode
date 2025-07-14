// problem link:
// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer

#include "LinkedList/ListNode.h"

class Solution {  // 0ms beats 100%
 public:
  int getDecimalValue(ListNode* head) {
    int total = 0;
    while (head) {
      total <<= 1;
      total |= head->val;
      head = head->next;
    }
    return total;
  }
};