class Solution {
    Map<String,Boolean> dp;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        dp=new HashMap<>();
        int len=words.length;
        Set<String> set=new HashSet<>();
        set.add(words[0]);
        
        List<String> res=new ArrayList<>();
        
        for(int i=1;i<len;i++){
            if(dfs(words[i],set))
                res.add(words[i]);
            set.add(words[i]);
            dp.put(words[i],true);
        }
        
        return res;
    }
    
    public boolean dfs(String str,Set<String> set){
        if(str.isEmpty())
            return true;
        if(dp.containsKey(str))
           return dp.get(str);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            if(set.contains(sb.toString()) && dfs(str.substring(i+1),set)){
                dp.put(str,true);
                return true;
            }
        }
        dp.put(str,false);
        return false;
    }
}