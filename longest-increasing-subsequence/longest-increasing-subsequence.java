class Solution {
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        int lo=0,hi=0,size=0;
        int[] dp=new int[len];
        
        
        for(int n:nums){
            lo=0;hi=size;
            while(lo<hi){
                int mid=(lo+hi)/2;
                if(dp[mid]<n)
                    lo=mid+1;
                else
                    hi=mid;
            }
            dp[lo]=n;
            if(lo==size) size++;
        }
        return size;
    }
}