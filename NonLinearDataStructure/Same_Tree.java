package NonLinearDataStructure;

public class Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null)
            return false;

        if (q == null && p != null)
            return false;

        if (p == null && q == null)
            return true;

        if (p.left == null && q.left != null || p.left != null && q.left == null || p.right == null && p.right != null
                || p.right != null && q.right == null)
            return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// Note
// 1. DFS
// 2. Check for root node value
// 3. Check for sub tree null values
