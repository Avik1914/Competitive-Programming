/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/

class Trie{
    Trie[] trieNode;
    boolean endOfWord;
    Trie(){
        trieNode=new Trie[26];
        endOfWord=false;
    }
}
class WordDictionary {
    Trie root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie temp=root;
        for(char c:word.toCharArray()){
            if(temp.trieNode[c-'a']==null)
                temp.trieNode[c-'a']=new Trie();
            temp=temp.trieNode[c-'a'];
        }
        temp.endOfWord=true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word.toCharArray(),root,0);
    }
    
    public boolean dfs(char[] arr,Trie root,int start){
        if(start==arr.length)
            return root.endOfWord;
        if(arr[start]=='.'){
            for(int i=0;i<26;i++){
                if(root.trieNode[i]!=null)
                    if(dfs(arr,root.trieNode[i],start+1))
                        return true;
            }
        }else if(root.trieNode[arr[start]-'a']!=null && dfs(arr,root.trieNode[arr[start]-'a'],start+1))
            return true;
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
