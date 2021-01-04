package com.problems.f;

import com.structure.TreeNode;

public class FlipEquivalentBinaryTrees {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                boolean x = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
                boolean y = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
                return x || y;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
