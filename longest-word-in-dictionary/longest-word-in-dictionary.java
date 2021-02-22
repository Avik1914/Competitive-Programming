class TrieNode{
    boolean isEndOfWord;
    TrieNode trieNode[];
    
    TrieNode(){
        trieNode=new TrieNode[26];
        isEndOfWord=false;
    }
}
class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        TrieNode trie=new TrieNode();
        String res="";
        boolean flag=false;
        for(String w:words){
            TrieNode root=trie;
            flag=true;
            for(int i=0;i<w.length();i++){
                char c=w.charAt(i);
                if(root.trieNode[c-'a']==null)
                    root.trieNode[c-'a']=new TrieNode();
                root=root.trieNode[c-'a'];
                if((i!=w.length()-1 && !root.isEndOfWord) || 
                    (i==w.length()-1 && root.isEndOfWord))
                    flag=false;
            }
            root.isEndOfWord=true;
            if(flag && res.length()<w.length())
                res=w;
        }
        return res;
    }
}