package MoreDataStructure;

import java.util.*;

public class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i)); // inserting the children of a node
            }
            node = node.get(word.charAt(i)); // getting the reference of the child node
        }
        node.isEnd = true; // setting the last node's flag to true indicating that the word is completed
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd; // if isEnd is true then the last word is reached
    }
    
    public boolean startsWith(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return true; // If any node is reached then it is sure that the word is a prefix
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


class Node{
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

// Note
// 1. We are going to create an N-ary tree
// 2. Every node will have children and a flag isEnd - The flag signifies if a word is completed