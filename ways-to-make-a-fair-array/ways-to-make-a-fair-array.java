class Solution {
    public int waysToMakeFair(int[] nums) {
        int len=nums.length;
        int oddSum=0;
        int evenSum=0;
        int[] os=new int[len];
        int[] es=new int[len];
        
        for(int i=0;i<len;i++){
            if(i%2==0)
                evenSum+=nums[i];
            else
                oddSum+=nums[i];
            os[i]=oddSum;
            es[i]=evenSum;
        }
        int res=0;
        
        oddSum=0;
        evenSum=0;
        
        
        for(int i=len-1;i>=0;i--){
            if(i!=0 && os[i-1]+evenSum==es[i-1]+oddSum)
                res++;
            if(i==0 && evenSum==oddSum)
                res++;
            if(i%2==0)
                evenSum+=nums[i];
            else
                oddSum+=nums[i];
        }
        
        return res;
    }
}