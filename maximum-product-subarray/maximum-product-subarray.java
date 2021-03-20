class Solution {
    public int maxProduct(int[] nums) {
        int minProd=0;
        int val=1;
        int len=nums.length;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                 minProd=0;
                 res=Math.max(res,0);
                 val=1;
            }else
                val=val*nums[i];
            if(val<0 && minProd==0)
                minProd=val;
            else if(val<0)
                res=Math.max(res,val/minProd);
            if(nums[i]!=0)
                res=Math.max(res,val);
        }
        return res;
    }
}