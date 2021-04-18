class Solution {
    public int findDuplicate(int[] nums) {
        int len=nums.length;
        
        int lo=1;
        int hi=len;
        
        while(lo<hi){
            int mid=(lo+hi)/2;
            int cnt=0;
            for(int i=0;i<len;i++){
                if(nums[i]<=mid)
                    cnt++;
            }
            if(cnt>mid)
                hi=mid;
            else
                lo=mid+1;
        }
        
        return lo;
    }
}