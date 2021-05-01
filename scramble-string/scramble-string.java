class Solution {
    Map<String,Boolean> map;
    public boolean isScramble(String s1, String s2) {
        map=new HashMap<>();
        return dfs(s1,s2);
    }
    
    public boolean dfs(String s1,String s2){
        String str=s1+","+s2;
        if(map.containsKey(str))
            return map.get(str);
        if(s1.equals(s2))
            return true;
        
        int len=s1.length();
       
        for(int i=0;i<len-1;i++){
            if(dfs(s1.substring(0,i+1),s2.substring(0,i+1))
              && dfs(s1.substring(i+1),s2.substring(i+1))){
                map.put(str,true);
                return true;
            }
            else if(dfs(s1.substring(0,i+1),s2.substring(len-i-1,len))
              && dfs(s1.substring(i+1),s2.substring(0,len-i-1))){
                map.put(str,true);
                return true;
            }
        }
        map.put(str,false);
        return false;
    }
}