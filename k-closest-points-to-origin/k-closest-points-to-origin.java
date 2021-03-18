class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int len=points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
                    
        
        for(int i=0;i<points.length;i++){
            pq.add(points[i]);
            if(pq.size()>k)
                pq.poll();
        }
        int[][] res=new int[k][2];
        
        for(int i=0;i<k;i++)
            res[i]=pq.poll();
        
        return res;
    }
}