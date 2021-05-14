class Trie{
    Trie[] trieNode;
    boolean isEndOfWord;
    String word;
    Trie(){
        trieNode=new Trie[26];
        isEndOfWord=false;
        word="";
    }
}

class Solution {
    String res="";
    public String longestWord(String[] words) {
        Trie root=new Trie();
        
        for(String w:words){
            Trie temp=root;
            for(char c:w.toCharArray()){
                if(temp.trieNode[c-'a']==null)
                    temp.trieNode[c-'a']=new Trie();
                temp=temp.trieNode[c-'a'];
            }
            temp.isEndOfWord=true;
            temp.word=w;
        }
        dfs(root);
        return res;
    }
    
    public void dfs(Trie root){
        if(root==null)
            return ;
        for(int i=0;i<26;i++){
            if(root.trieNode[i]!=null && root.trieNode[i].isEndOfWord){
               
                if(res.length()<root.trieNode[i].word.length())
                    res=root.trieNode[i].word;
                else if(res.length()==root.trieNode[i].word.length() && res.compareTo(root.trieNode[i].word)>0)
                    res=root.trieNode[i].word;
                dfs(root.trieNode[i]);
                    
            }
        }
    }
}