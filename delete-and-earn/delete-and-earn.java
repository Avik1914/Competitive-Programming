class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] lkp=new int[10001];
        
        for(int n:nums)
            lkp[n]+=n;
        int res=0;
        for(int i=2;i<10001;i++)
            lkp[i]=Math.max(lkp[i-1],lkp[i]+lkp[i-2]);
        
            
        return lkp[10000];
    }
}