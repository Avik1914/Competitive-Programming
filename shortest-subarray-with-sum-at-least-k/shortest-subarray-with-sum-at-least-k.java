class Solution {
    public int shortestSubarray(int[] A, int K) {
        int len=A.length;
        int sum=A[0];
        if(len==1 && sum>=K)
            return 1;
        Deque<int[]> deque=new LinkedList();
        deque.add(new int[]{sum,0});
        int res=len+1;
        for(int i=1;i<len;i++){
            if(sum+A[i]<A[i]){
                deque.clear();
                deque.add(new int[]{A[i],i});
                sum=A[i];
            }
            else{
                sum=sum+A[i];
                int ind=i;
                while(!deque.isEmpty() && deque.getLast()[0]>=sum)
                    ind=deque.removeLast()[1];
                deque.addLast(new int[]{sum,ind});
            }
            
            while(!deque.isEmpty() && sum-deque.getFirst()[0]>=K)
                 deque.removeFirst();
        
            if(sum>=K)
                res=Math.min(i-deque.getFirst()[1]+1,res);
            
        }
        return res==len+1?-1:res;
    }
}
