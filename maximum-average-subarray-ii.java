class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double lo=-10000;
        double hi=10000;
        double res=0.0;
        while(hi-lo>=1e-5){
            double mid=(hi+lo)/2.0;
            if(check(nums,k,mid)){
                lo=mid;
                res=mid;
            }
            else
                hi=mid;
        }
        return res;
    }
    
    public boolean check(int[] nums,int k,double mid){
        int len=nums.length;
        int start=0;
        double sum=0.0;
        double prevSum=0.0;
        double prevMin=0.0;
        for(int i=0;i<len;i++){
            sum+=nums[i]-mid;
            if(i+1>=k){
                if(sum-prevMin>=0)
                    return true;
                prevSum+=nums[start]-mid;
                prevMin=Math.min(prevSum,Math.min(nums[start],prevMin));
                start++;
            }
        }
        return false;
    }
}
