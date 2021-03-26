class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len=gas.length;
        int[] sum=new int[len+1];
        
        for(int i=0;i<len;i++)
            sum[i+1]=gas[i]-cost[i];            
        int sumSoFar=0;
        int minSoFar=0;
        int start=0;
        for(int i=0;i<len;i++){
             sumSoFar+=sum[i+1];
             if(minSoFar>sumSoFar)
                 start=i+1;
             minSoFar=Math.min(sumSoFar,minSoFar);
        }
        
        for(int i=0;i<len;i++){
            sumSoFar+=sum[((i+start)%len)+1]; 
            if(sumSoFar<0)
                return -1;
             
        }
        
        return start;
    }
}