class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> graph=new HashMap();
        
        for(int i=1;i<=n;i++)
            graph.put(i,new ArrayList());
        
        for(int[] t:times)
            graph.get(t[0]).add(new int[]{t[1],t[2]});
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        pq.add(new int[]{k,0});
        int[] dist=new int[n+1];
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        
        while(!pq.isEmpty()){
            int[] val=pq.poll();
            for(int[] no:graph.get(val[0])){
                if(dist[no[0]]>val[1]+no[1]){
                    dist[no[0]]=val[1]+no[1];
                    pq.add(new int[]{no[0],dist[no[0]]});
                }
            }
        }
        int res=Integer.MIN_VALUE;
        
        for(int i=1;i<=n;i++)
            res=Math.max(res,dist[i]);
        
        return res==Integer.MAX_VALUE?-1:res;
    }
}