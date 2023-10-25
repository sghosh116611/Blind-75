class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i));
            }
            node = node.get(word.charAt(i));
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


public class Node{
    Node[] children;
    boolean isEnd;

    Node(){
        children = new Node[26];
        isEnd = false;
    }

    boolean containsKey(char ch){
        return children[ch - 'a'] != null;
    }

    void put(char ch){
        children[ch - 'a'] = new Node();
    }

    Node get(char ch){
        return children[ch - 'a'];
    }
}