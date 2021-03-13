class Solution {
    public void sortColors(int[] nums) {
        int len=nums.length;
        
        int lo=-1;
        int hi=len;
        int mid=0;
        
        while(mid<hi){
            if(nums[mid]==2){
                swap(nums,mid,hi-1);
                hi--;
            }else if(nums[mid]==0){
                swap(nums,lo+1,mid);
                lo++;
                mid++;
            }else
                mid++;
        }
    }
    
    
    
    public void swap(int nums[],int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}