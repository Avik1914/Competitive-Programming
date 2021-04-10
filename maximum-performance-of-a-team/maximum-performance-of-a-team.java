class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<int[]> li=new ArrayList();
        
        for(int i=0;i<n;i++)
            li.add(new int[]{speed[i],efficiency[i]});
        
        Collections.sort(li,(a,b)->b[1]-a[1]);
        long sum=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long res=0;
        
        for(int i=0;i<n;i++){
            sum+=(long)li.get(i)[0];
            pq.add(li.get(i)[0]);
            
            if(pq.size()>k)
                sum-=pq.poll();
            
            res=Math.max(res,sum*(long)li.get(i)[1]);
        }
        
        return (int)(res%(long)(1e9+7));
    }
}