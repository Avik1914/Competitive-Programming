class TrieNode{
    TrieNode[] node;
    int prefixes;
    int end;
    TrieNode(){
        node=new TrieNode[26];
        prefixes=0;
        end=0;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp=root;
        
        for(char c:word.toCharArray()){
            if(temp.node[c-'a']==null)
                temp.node[c-'a']=new TrieNode();
            temp.prefixes++;
            temp=temp.node[c-'a'];
        }
        temp.prefixes++;
        temp.end++;
    }
    
    public int countWordsEqualTo(String word) {
        TrieNode temp=root;
        
        for(char c:word.toCharArray()){
            if(temp.node[c-'a']==null)
                return 0;
            temp=temp.node[c-'a'];
        }
        return temp.end;
    }
    
    public int countWordsStartingWith(String prefix) {
        TrieNode temp=root;
        
        for(char c:prefix.toCharArray()){
            if(temp.node[c-'a']==null)
                return 0;
            temp=temp.node[c-'a'];
        }
        return temp.prefixes;
    }
    
    public void erase(String word) {
        TrieNode temp=root;
        
        for(char c:word.toCharArray()){
            temp.prefixes--;
            temp=temp.node[c-'a'];
        }
        temp.prefixes--;
        temp.end--;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */