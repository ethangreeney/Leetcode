// problem link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

package Trees;

class Solution {

    private TreeNode res;
    private int k;

    public int kthSmallest(TreeNode root, int k) {

        this.k = k;
        inOrderHelper(root);
        return res.val;

    }

    private void inOrderHelper(TreeNode root) {

        if (root == null || res != null) {
            return;
        }

        inOrderHelper(root.left);

        if (k-- == 1) {
            res = root;
        }

        inOrderHelper(root.right);

    }
}