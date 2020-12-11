class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer,List<int[]>> map=new HashMap();
        
        for(int i=0;i<n;i++)
            map.put(i,new ArrayList());
        
        for(int[] e:edges){
            map.get(e[0]).add(new int[]{e[1],e[2]});
            map.get(e[1]).add(new int[]{e[0],e[2]});
        }
        int cnt=n;
        int res=0;
        for(int i=0;i<n;i++){
            
            int num=0;
            int[] dist=new int[n];
            boolean[] visit=new boolean[n];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[i]=0;
            visit[i]=true;
            PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->dist[a]-dist[b]);
            pq.add(i);
            
            while(!pq.isEmpty() && num<n){
                int val=pq.poll();
                if(dist[val]>distanceThreshold)
                    break;
                for(int[] v:map.get(val)){
                    if(v[1]+dist[val]<dist[v[0]]){
                        dist[v[0]]=dist[val]+v[1];
                        if(!visit[v[0]] && dist[v[0]]<=distanceThreshold){
                            pq.add(v[0]);
                            visit[v[0]]=true;
                            num++;
                        }
                    }
                }
            }
            //System.out.println(i+","+num);
            if(cnt>=num){
                cnt=num;
                res=i;
            }
        }
        return res;
    }
}
