class TrieNode{
    TrieNode[] nodes;
    boolean isEndOfWord;
    
    TrieNode(){
        nodes=new TrieNode[26];
        isEndOfWord=false;
    }
}
class Trie {
    TrieNode trie;
    /** Initialize your data structure here. */
    public Trie() {
        trie=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode root=trie;
        
        for(char c:word.toCharArray()){
            if(root.nodes[c-'a']==null)
                root.nodes[c-'a']=new TrieNode();
            root=root.nodes[c-'a'];
        }
        root.isEndOfWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode root=trie;
        for(char c:word.toCharArray()){
            if(root.nodes[c-'a']==null)
                return false;
            root=root.nodes[c-'a'];
        }
        return root.isEndOfWord;
    }
    
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode root=trie;
        for(char c:prefix.toCharArray()){
            if(root.nodes[c-'a']==null)
                return false;
            root=root.nodes[c-'a'];
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