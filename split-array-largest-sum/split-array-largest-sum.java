class Solution {
    public int splitArray(int[] nums, int m) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int n:nums){
            sum+=n;
            max=Math.max(max,n);
        }
        
        int lo=max;
        int hi=sum;
        
        while(lo<hi){
            int mid=lo+((hi-lo)/2);
            if(check(nums,mid,m)<= m)
                hi=mid;
            else
                lo=mid+1;
        }
    
        return lo;
    }
    
    public int check(int[] nums,int sum,int m){
        int s=0;
        int cnt=0;
        for(int n:nums){
            s+=n;
            if(s>=sum){
                cnt++;
                s=s>sum?n:0;
            }
        }
        if(s>0)
            cnt++;
        //System.out.println(sum+","+cnt);
        return cnt;
    }
}
