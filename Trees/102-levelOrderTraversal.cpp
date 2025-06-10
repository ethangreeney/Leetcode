#include <vector>

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right)
      : val(x), left(left), right(right) {}
};
class DFSPreOrderTraversal {  // 0ms beats 100%
  std::vector<std::vector<int>> levelOrder(TreeNode *root) {
        std::vector<std::vector<int>> result;
    if (root == nullptr) {
      return result;
    }

    levelOrder(root, 0, result);
    return result;
  }

  void levelOrder(TreeNode *currentNode, int height,
                  std::vector<std::vector<int>> &result) {
    if (currentNode == nullptr) {
      return;
    }

    if (height == result.size()) {
      result.emplace_back();
    }
    result.at(height).push_back(currentNode->val);

    levelOrder(currentNode->left, height + 1, result);
    levelOrder(currentNode->right, height + 1, result);
  }
};