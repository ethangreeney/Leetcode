//problem link: https://leetcode.com/problems/maximum-depth-of-binary-tree/

package Trees;

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

class OneLiner {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
