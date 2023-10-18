package NonLinearDataStructure;

public class Max_Depth_Tree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left + 1, right + 1);
    }
}

// Note
// 1. Perform DFS
// 2. Find the depth of left sub tree
// 3. Find depth of right sub tree
// 4. Return the maximum
