package MoreDataStructure;

public class Kth_Smallest_BST {
    int count = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
       helper(root,k);
       return result;
    }

    public void helper(TreeNode root, int k){
        if(root == null)
            return ;

        helper(root.left,k);
        count++;
        if(count == k)
            result = root.val;
        helper(root.right,k);
    }
}
