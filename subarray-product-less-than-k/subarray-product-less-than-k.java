class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int val=1;
        
        int start=0;
        int res=0;
         if(k==0)
             return 0;
        for(int i=0;i<nums.length;i++){
            val=val*nums[i];
            while(start<i && val>=k)
                val=val/nums[start++];
            if(val<k)
                res+=i-start+1;
        }
        return res;
    }
}