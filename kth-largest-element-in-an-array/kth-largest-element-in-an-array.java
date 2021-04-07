class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len=nums.length;
        int lo=0;
        int hi=len-1;
        
        while(lo<=hi){
            int val=quickSelect(nums,lo,hi);
            
            if(val==len-k)
                return nums[val];
            if(val<len-k)
                lo=val+1;
            else
                hi=val-1;
        }
        
        return -1;
    }
    
    public int quickSelect(int[] nums,int lo,int hi){
        int pivot=nums[hi];
        
        int i=lo-1,j=lo;
        
        while(j<hi){
            if(nums[j]<pivot){
                int temp=nums[i+1];
                nums[i+1]=nums[j];
                nums[j]=temp;
                i++;
            }
            j++;
        }
        int temp=nums[i+1];
        nums[i+1]=nums[hi];
        nums[hi]=temp;
        return i+1;
    }
}