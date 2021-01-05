class Solution {
    public int shortestSubarray(int[] A, int K) {
        int len=A.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int sum=0;
        int res=len+1;
        for(int i=0;i<len;i++){
            sum+=A[i];
            if(sum>=K)
                res=Math.min(res,i+1);
            
            while(!pq.isEmpty() && sum-pq.peek()[0]>=K)
                res=Math.min(res,i-pq.poll()[1]);
            
            pq.add(new int[]{sum,i});
        }
        
        return res==len+1?-1:res;
    }
}
