class Solution {
    public int firstMissingPositive(int[] nums) {
        int len=nums.length;
        
        for(int i=0;i<len;i++){
          
            int temp=nums[i];
            while(temp>0 && temp<=len && nums[temp-1]!=temp){
                int val=nums[temp-1];
                nums[temp-1]=temp;
                temp=val;
            }
            
        }
        
        for(int i=0;i<len;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        
        return len+1;
            
    }
}