// problem link: https://leetcode.com/problems/validate-binary-search-tree/description/

package Trees;

import java.util.ArrayList;
import java.util.List;

class NaiveSolution { // 195 ms Beats 2.28%

    private List<Integer> treeAsList = new ArrayList<Integer>();

    boolean isValidBST(TreeNode root) {

        inOrderHelper(root);

        Object[] inOrderArray = treeAsList.toArray();

        for (int i = 1; i < inOrderArray.length; i++) {
            if ((int) inOrderArray[i] <= (int) inOrderArray[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private void inOrderHelper(TreeNode root) {

        if (root == null) {
            return;
        }

        isValidBST(root.left);
        treeAsList.add(root.val);
        isValidBST(root.right);
    }

}

class ImprovedSpaceComplxityFarMorePerformant { // 0 ms Beats 100%

    private Integer lastSeen;
    private boolean valid = true;

    boolean isValidBST(TreeNode root) {

        inOrderHelper(root);
        return valid;

    }

    private void inOrderHelper(TreeNode root) {

        if (root == null || valid == false) {
            return;
        }

        inOrderHelper(root.left);

        if (lastSeen == null) {
            lastSeen = root.val;
        } else {
            if (root.val <= lastSeen) {
                valid = false;
                return;
            }
            lastSeen = root.val;
        }

        inOrderHelper(root.right);
    }

}

class PrevSolutionMoreConcice { // 0 ms Beats 100%

    private Integer lastSeen;

    boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (isValidBST(root.left) == false) {
            return false;
        }

        if (lastSeen != null && lastSeen >= root.val) {
            return false;
        }

        lastSeen = root.val;

        return isValidBST(root.right);
    }

}