class Solution {
    public void sortColors(int[] nums) {
        int len=nums.length;
        int lo=-1;
        int mid=0;
        int hi=len-1;
        
        while(mid<=hi){
            if(nums[mid]==0){
                swap(nums,lo+1,mid);
                lo++;
                mid++;
            }else if(nums[mid]==2){
                swap(nums,mid,hi);
                hi--;
            }else
                mid++;
        }
    
    }
    
    public void swap(int[] nums,int lo,int hi){
        int a=nums[lo];
        nums[lo]=nums[hi];
        nums[hi]=a;
    }
}