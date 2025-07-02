// problem link: https://leetcode.com/problems/same-tree/

#include "TreeNode.h"

class Solution {  // 0ms beats 100%
 public:
  bool isSameTree(TreeNode* p, TreeNode* q) {
    if (p == nullptr && q == nullptr) {
      return true;
    }
    if (p == nullptr ^ q == nullptr || p->val != q->val) {
      return false;
    }
    return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
  }
};