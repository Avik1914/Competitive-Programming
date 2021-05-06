class TrieNode{
    TrieNode[] nodes;
    boolean isEndOfWord;
    
    TrieNode(){
        nodes=new TrieNode[26];
        isEndOfWord=false;
    }
}
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp=root;
        
        for(char c:word.toCharArray()){
            if(temp.nodes[c-'a']==null)
                temp.nodes[c-'a']=new TrieNode();
            temp=temp.nodes[c-'a'];
        }
        temp.isEndOfWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp=root;
        
        for(char c:word.toCharArray()){
            if(temp.nodes[c-'a']==null)
                return false;
            temp=temp.nodes[c-'a'];
        }
        return temp.isEndOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp=root;
        
        for(char c:prefix.toCharArray()){
            if(temp.nodes[c-'a']==null)
                return false;
            temp=temp.nodes[c-'a'];
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