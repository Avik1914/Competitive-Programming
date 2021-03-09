class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len=nums.length;
        if(len==0)
            return new int[]{-1,-1};
        int lo=0,hi=len-1;
        int[] res=new int[2];
        
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(nums[mid]<target)
                lo=mid+1;
            else
                hi=mid;
        }
        res[0]=nums[lo]!=target?-1:lo;
        lo=0;hi=len-1;
        while(lo<hi){
            int mid=(lo+hi)/2+1;
            if(nums[mid]<=target)
                lo=mid;
            else
                hi=mid-1;
        }
        res[1]=nums[lo]!=target?-1:lo;
        return res;
    }
}