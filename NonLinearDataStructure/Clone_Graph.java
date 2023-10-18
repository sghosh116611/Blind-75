package NonLinearDataStructure;

import java.util.*;

public class Clone_Graph {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Node newNode = new Node(node.val);
        HashMap<Integer, Node> map = new HashMap(); 
        
        map.put(newNode.val, newNode);
        
        LinkedList<Node> queue = new LinkedList(); 
        queue.add(node); 
        
        while (!queue.isEmpty()) { 
            Node n = queue.pop();
            for (Node neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.val)) { 
                    map.put(neighbor.val, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                map.get(n.val).neighbors.add(map.get(neighbor.val));
            }
        }
        
        return newNode;
    }
}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

// Note
// 1. We need to dereference and create new references for the graph (copy of the graph)
// 2. 2. BFS and HashMap -> Add Nodes and neighbors in Hashamap

