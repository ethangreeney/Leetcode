// problem link: https://leetcode.com/problems/invert-binary-tree/

#include <algorithm>

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right)
      : val(x), left(left), right(right) {}
};

class Solution {  // 0ms beats 100%
 public:
  TreeNode *invertTree(TreeNode *root) {
    if (root == nullptr) {
      return nullptr;
    }

    std::swap(root->left, root->right);

    invertTree(root->left);
    invertTree(root->right);

    return root;
  }
};