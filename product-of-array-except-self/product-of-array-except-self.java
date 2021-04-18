class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        
        int[] left=new int[len+1];
        left[0]=1;
        int mul=1;
        for(int i=0;i<len;i++){
            mul=mul*nums[i];
            left[i+1]=mul;
        }
        int[] res=new int[len];
        mul=1;
        for(int i=len-1;i>=0;i--){
            res[i]=mul*left[i];
            mul=mul*nums[i];
        }
        
        return res;
    }
}