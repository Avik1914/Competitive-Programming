class Solution {
    int[] dist;
    Integer[] dp;
    public int countRestrictedPaths(int n, int[][] edges) {
        List<int[]>[] graph=new ArrayList[n+1];
        dp=new Integer[n+1];
        for(int i=1;i<=n;i++)
            graph[i]=new ArrayList();
        
        for(int[] e:edges){
            graph[e[0]].add(new int[]{e[1],e[2]});
            graph[e[1]].add(new int[]{e[0],e[2]});
        }
        
        dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        dist[n]=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->dist[a]-dist[b]);
        pq.add(n);
        
        while(!pq.isEmpty()){
            int val=pq.poll();
            for(int[] e:graph[val]){
                if(dist[e[0]]>e[1]+dist[val]){
                    dist[e[0]]=e[1]+dist[val];
                    pq.add(e[0]);
                }
            }
        }
        
        return dfs(graph,1,n,dist[1],new boolean[n+1]);
    }
    
    public int dfs(List<int[]>[] graph,int start,int end,int prev,boolean[] visit){
        if(start==end)
            return 1;
        long val=0;
        if(dp[start]!=null)
            return dp[start];
        visit[start]=true;
        for(int[] e:graph[start]){
            if(!visit[e[0]] && prev>dist[e[0]])
                val+=dfs(graph,e[0],end,dist[e[0]],visit);
        }
        visit[start]=false;
        dp[start]=(int)(val%1000000007);
        return dp[start];
    }
}