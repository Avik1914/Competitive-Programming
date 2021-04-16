class Solution {
    Map<Integer,Integer> map;
    boolean[] visited;
    Map<String,Boolean> dp;
    public boolean canCross(int[] stones) {
        map=new HashMap<>();
        dp=new HashMap<>();
        visited=new boolean[stones.length];
        for(int i=0;i<stones.length;i++)
            map.put(stones[i],i);
        
        
        return dfs(stones,1,1);
    }
    
    public boolean dfs(int stones[],int prevUnit,int start){
         if(!map.containsKey(start) || visited[map.get(start)])
            return false;
        String str=prevUnit+","+start;
         if(dp.get(str)!=null)
             return dp.get(str);
         visited[map.get(start)]=true;
        if(map.get(start)==stones.length-1)
            return true;
     
        boolean flag= dfs(stones,prevUnit+1,start+prevUnit+1)
                ||
                dfs(stones,prevUnit-1,start+prevUnit-1)
                ||
                dfs(stones,prevUnit,start+prevUnit);
        dp.put(str,flag);
        visited[map.get(start)]=false;
        return flag;
    }
    
}