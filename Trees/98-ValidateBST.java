// problem link: https://leetcode.com/problems/validate-binary-search-tree/description/

package Trees;

import java.util.ArrayList;
import java.util.List;

class Solution { // 195 ms Beats 2.28%

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