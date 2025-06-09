// problem link: https://leetcode.com/problems/binary-tree-level-order-traversal/

package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution { // 1ms beats 89%
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> currentLevel = new ArrayList<>();

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                TreeNode currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

                currentLevel.add(currentNode.val);
            }

            result.add(currentLevel);

        }
        return result;
    }
}

class preOrderDFS { // 0 ms beats 100%
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        dfsHelper(root, 0, result);

        return result;

    }

    private void dfsHelper(TreeNode currentNode, int height, List<List<Integer>> result) {

        if (currentNode == null) {
            return;
        }

        if (result.size() == height) {
            result.add(new ArrayList<>());
        }

        result.get(height).add(currentNode.val);

        dfsHelper(currentNode.left, height + 1, result);
        dfsHelper(currentNode.right, height + 1, result);

    }
}
