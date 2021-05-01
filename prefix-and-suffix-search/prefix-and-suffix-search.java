class Trie{
    Trie[] trie=new Trie[27];
    int ind=-1;
}
class WordFilter {
    Trie root;
    public WordFilter(String[] words) {
        root=new Trie();
        Trie run=root;
        int wordLen=words.length;
        
        for(int i=0;i<wordLen;i++){
            String s=words[i];
            int len=s.length();
            StringBuilder sb=new StringBuilder();
            
            for(int j=len-1;j>=0;j--){
                sb.insert(0,s.charAt(j));    
                run=root;
                for(char c:(sb.toString()+"{"+s).toCharArray()){
                    if(run.trie[c-'a']==null)
                        run.trie[c-'a']=new Trie();
                    run.trie[c-'a'].ind=i;
                    run=run.trie[c-'a'];
                }
                
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        Trie run=root;
        for(char c:(suffix+"{"+prefix).toCharArray()){
            if(run.trie[c-'a']==null)
                return -1;
            run=run.trie[c-'a'];
        }
        return run.ind;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */