class Solution {
    Map<String,Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        map=new HashMap<>();
        Set<String> set=new HashSet<>(wordDict);
        return dfs(s,set);
    }
    
    public boolean dfs(String s,Set<String> set){
        if(s.length()==0)
            return true;
        if(map.containsKey(s))
            return map.get(s);
        map.put(s,false);
        for(int i=1;i<=s.length();i++){
            if(set.contains(s.substring(0,i)) && dfs(s.substring(i),set)){
                map.put(s,true);
                break;
            }
                
        }
        return map.get(s);
    }
}