class Solution {
    public int shortestSubarray(int[] A, int K) {
        Deque<int[]> deque=new LinkedList();
        
        int len=A.length;
        int sum=0;
        int res=len+1;
        int start=0;
        for(int i=0;i<len;i++){
            sum+=A[i];
            start=i;
            
            int val=0;
            while(!deque.isEmpty() && sum-deque.peekFirst()[0]>=K)
                res=Math.min(res,i-deque.pollFirst()[1]);
            while(!deque.isEmpty() && deque.peekLast()[0]>=sum)
                start=deque.pollLast()[1];
            
            if(sum>=K)
                res=Math.min(res,i+1);
            deque.add(new int[]{sum,i});
        }
        
        return res==len+1?-1:res;
    }
}