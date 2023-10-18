package NonLinearDataStructure;

import java.util.*;

public class Level_Order_Tree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultLevelOrder = new ArrayList<>();

        if(root == null)
            return resultLevelOrder;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> levelArray = new ArrayList<>();
            for(int i = 1; i <= level; i++){
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                
                if(node.right != null)
                    queue.add(node.right);

                levelArray.add(node.val);
            }
            resultLevelOrder.add(levelArray);
        }

        return resultLevelOrder;
    }
}

//Note
// 1. BFS
// 2. Maintain a queue -> After the nodes are added the current size of the queue is the current level of the tree
