class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int len=candiesCount.length;
        long[] prefixSum=new long[len+1];
        long sum=0;
        
        for(int i=0;i<len;i++){
            sum+=candiesCount[i];
            prefixSum[i+1]=sum;
        }
        
        int queryLen=queries.length;
        boolean[] res=new boolean[queryLen];
        long temp=0l;
        
        for(int i=0;i<queryLen;i++){
            long val=prefixSum[queries[i][0]];
            temp=(long)queries[i][2]*(long)(queries[i][1]+1);
            
            if(temp<=val || prefixSum[queries[i][0]+1]<=queries[i][1])
                res[i]=false;
            else
                res[i]=true;
        }
        return res;
        
    }
}