class Solution {
    public int shortestSubarray(int[] A, int K) {
        PriorityQueue<int[]> pq=new PriorityQueue<>
                ((a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int len=A.length;
        int sum=0;
        int start=-1;
        int val=0;
        int res=len+1;
        for(int i=0;i<len;i++){
            sum+=A[i];
            val=0;
            while(!pq.isEmpty() && sum-pq.peek()[0]>=K){
                int[] pop=pq.poll();
                if(start<pop[1]){
                    start=pop[1];
                    val=pop[0];
                }
            }
            if(sum-val>=K)
                res=Math.min(res,i-start);
            pq.add(new int[]{sum,i});
        }
        
        return res==len+1?-1:res;
    }
}