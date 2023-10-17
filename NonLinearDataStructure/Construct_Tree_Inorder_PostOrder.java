package NonLinearDataStructure;

import java.util.HashMap;

public class Construct_Tree_Inorder_PostOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode resultRoot = builderHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);

        return resultRoot;
    }

    public TreeNode builderHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            HashMap<Integer, Integer> map) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inIdx = map.get(preorder[preStart]);
        int numsLeft = inIdx - inStart;

        root.left = builderHelper(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inIdx - 1, map);
        root.right = builderHelper(preorder, preStart + numsLeft + 1, preEnd, inorder, inIdx + 1, inEnd, map);

        return root;

    }
}

// Note
// 1. Left node will be determined :-
// 		a. PreOrder Start -> PreStart + 1
// 		b. PreOrder End ->  InOrder root idx - InorderStart
// 		c. Inorder Start -> InStart
// 		d. InOrder End -> InOrder root Idx - 1

// 2. Right Node will be determined :-
// 		a. PreOrder Start -> InOrder root Idx - InOrderStart + 1
// 		b. PreOrder End -> PreEnd
// 		c. InOrder Start -> InOrder rootIdx + 1
// 		d. InOrder End -> InEnd