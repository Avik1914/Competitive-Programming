class Trie{
    Trie node[];
    boolean endOfWord;
    Trie(){
        node=new Trie[26];
        endOfWord=false;
    }
}
class StreamChecker {
    Trie root;
    StringBuilder sb;
    public StreamChecker(String[] words) {
        root=new Trie();
        sb=new StringBuilder();
        Trie temp=root;
        for(String w:words){
            temp=root;
            for(int i=w.length()-1;i>=0;i--){
                if(temp.node[w.charAt(i)-'a']==null)
                    temp.node[w.charAt(i)-'a']=new Trie();
                temp=temp.node[w.charAt(i)-'a'];
            }
            temp.endOfWord=true;
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        Trie temp=root;
        for(int i=sb.length()-1;i>=0;i--){
            
            char c=sb.charAt(i);
            if(temp.node[c-'a']!=null)
                temp=temp.node[c-'a'];
            else
                return false;
            if(temp.endOfWord)
                return true;
        }
       
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
