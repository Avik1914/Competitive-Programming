class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int len=words.length;
        List<String> res=new ArrayList<>();
        
        for(String w:words){
            int[] lkp=new int[26];
            boolean[] isTaken=new boolean[26];
            Arrays.fill(lkp,-1);
           
            if(pattern.length()==w.length()){
                 boolean flag=true;
                 int itr=0;
                for(char c:pattern.toCharArray()){
                    if(lkp[c-'a']==-1 && !isTaken[w.charAt(itr)-'a']){
                        lkp[c-'a']=w.charAt(itr);
                        isTaken[w.charAt(itr)-'a']=true;
                    }
                    if(lkp[c-'a']!=w.charAt(itr)){
                        flag=false;
                        break;
                    }
                    itr++;
                }
                if(flag)
                    res.add(w);
            }
        }
        
        return res;
    }
}