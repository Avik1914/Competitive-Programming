class Solution {
    public void nextPermutation(int[] nums) {
        int len=nums.length;
        int prev=-1;
        int ind=-1;
        
        for(int i=len-1;i>=0;i--){
            if(prev>nums[i]){
                ind=i;
                break;
            }else
                prev=nums[i];
        }
        if(ind==-1){
            reverse(nums,0,len-1);
            return;
        }
        int otherInd=ind+1;
        for(int i=ind+1;i<len;i++){
            if(nums[ind]<nums[i] && nums[otherInd]>=nums[i])
                otherInd=i;
        }
        int temp=nums[ind];
        nums[ind]=nums[otherInd];
        nums[otherInd]=temp;
        reverse(nums,ind+1,len-1);
    }
    
    public void reverse(int[] nums,int lo,int hi){
        
        
        while(lo<hi){
            int temp=nums[lo];
            nums[lo]=nums[hi];
            nums[hi]=temp;
            lo++;
            hi--;
        }
    }
}