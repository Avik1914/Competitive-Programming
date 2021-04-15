class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        Map<Integer,List<int[]>> map=new HashMap<>();
        
        for(int i=0;i<n;i++)
            map.put(i+1,new ArrayList());
        
        for(int[] p:pipes){
            map.get(p[0]).add(new int[]{p[1],p[2]});
            map.get(p[1]).add(new int[]{p[0],p[2]});
        }
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        for(int i=1;i<=n;i++)
            pq.add(new int[]{i,wells[i-1]});
        
        int res=0;
        boolean[] visit=new boolean[n+1];
        while(n>0){
            int[] val=pq.poll();
            if(visit[val[0]])
                continue;
            res+=val[1];
            visit[val[0]]=true;
            n--;
            for(int[] p:map.get(val[0])){
                if(!visit[p[0]])
                    pq.add(p);
            }
        }
        return res;
    }
}