class ValidWordAbbr {
    Map<String,Integer> cnt;
    Map<String,Integer> abrCnt;
    public ValidWordAbbr(String[] dictionary) {
        cnt=new HashMap();
        abrCnt=new HashMap();
        
        for(String s:dictionary){
            int len=s.length();
            if(len-2<=0)
                abrCnt.put(s,abrCnt.getOrDefault(s,0)+1);
            else{
                String str=s.charAt(0)+""+(len-2)+""+s.charAt(len-1);
                abrCnt.put(str,abrCnt.getOrDefault(str,0)+1);
            }
            cnt.put(s,cnt.getOrDefault(s,0)+1);
        }
    }
    
    public boolean isUnique(String word) {
        int len=word.length();
        String str="";
        if(len-2<=0)
            str=word;
        else
            str=word.charAt(0)+""+(len-2)+""+word.charAt(len-1);
        if(!abrCnt.containsKey(str))
            return true;
        return cnt.get(word)==abrCnt.get(str);
    }
}
​
/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
