class Solution {
    public int maxLength(int[] ribbons, int k) {
        long sum=0;
        for(int r:ribbons)
            sum+=r;
        
        long lo=0;
        long hi=sum;
        
        while(lo<hi){
            long mid=lo+(hi-lo)/2+1;
            long cnt=0;
            for(int r:ribbons)
                cnt+=r/mid;
            if(cnt>=k)
                lo=mid;
            else
                hi=mid-1;
        }
        
        return (int)lo;
    }
}