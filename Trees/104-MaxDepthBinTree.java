//problem link: https://leetcode.com/problems/maximum-depth-of-binary-tree/

package Trees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class DFS {
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftSubtree = maxDepth(root.left);
        int rightSubtree = maxDepth(root.right);

        return leftSubtree > rightSubtree ? ++leftSubtree : ++rightSubtree;

    }
}
