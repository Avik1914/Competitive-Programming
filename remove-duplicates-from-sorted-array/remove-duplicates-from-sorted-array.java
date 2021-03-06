class Solution {
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        int fastPtr=0;
        int slowPtr=0;
        
        while(fastPtr<len){
            nums[slowPtr]=nums[fastPtr];
            int val=nums[fastPtr];
            while(fastPtr<len && nums[fastPtr]==val)
                fastPtr++;
            slowPtr++;
        }
        
        return slowPtr;
    }
}