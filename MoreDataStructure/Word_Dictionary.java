package MoreDataStructure;

class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
       Node node = root;
       for(int i = 0; i < word.length();i++){
           if(!node.containsKey(word.charAt(i))){
               node.put(word.charAt(i));
           }
           node = node.get(word.charAt(i));
       }
       node.isEnd = true; 
    }
    
    public boolean search(String word) {
        Node node = root;
        return node.searchHelper(word);
       
    }
}

class Node{
    Node[] children;
    boolean isEnd;

    Node(){
        children = new Node[26];
        isEnd = false;
    }

    boolean containsKey(char ch){
        return this.children[ch - 'a'] != null;
    }

    void put(char ch){
        this.children[ch - 'a'] = new Node();
    }

    Node get(char ch){
        return this.children[ch - 'a'];
    }

    public boolean searchHelper(String word) {
        Node node = this;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == '.'){
                for(Node nTemp : node.children){
                    if(nTemp != null && nTemp.searchHelper(word.substring(i + 1))){
                        return true;
                    }
                }
                return false;
            }else if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
            
        }
        return node != null && node.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

//  Note
//  1. Trie DS
// 2. DFS to match '.'