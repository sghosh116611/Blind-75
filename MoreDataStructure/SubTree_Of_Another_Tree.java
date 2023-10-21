package MoreDataStructure;

public class SubTree_Of_Another_Tree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root != null) {
            if (checkSameTree(root, subRoot))
                return true;
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        return false;
    }

    public boolean checkSameTree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null)
            return true;

        if (root == null || subRoot == null)
            return false;

        return root.val == subRoot.val && checkSameTree(root.left, subRoot.left)
                && checkSameTree(root.right, subRoot.right);
    }
}

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
