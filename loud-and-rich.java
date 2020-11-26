class Solution {
    int[] dp;
    
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n=quiet.length;
        Map<Integer,List<Integer>> map=new HashMap();
        Map<Integer,Integer> quietMap=new HashMap();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList());
            quietMap.put(quiet[i],i);
        }
        
        for(int[] r:richer)
            map.get(r[1]).add(r[0]);
        boolean[] visit=new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visit[i])
                dfs(map,i,quiet,visit);
        }
        
        for(int i=0;i<n;i++)
            quiet[i]=quietMap.get(quiet[i]);
        return quiet;
    }
    
    
    public int dfs(Map<Integer,List<Integer>> map,int root,int[] quiet,boolean[] visit){
        if(visit[root])
            return quiet[root];
        
        int val=quiet[root];
        visit[root]=true;
        
        for(int i:map.get(root))
            val=Math.min(val,dfs(map,i,quiet,visit));
        
        quiet[root]=val;
        return val;
    }
}
