class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum=0;
        for(int n:nums)
            sum+=(long)n;
        
        sum=(long)goal-(long)sum;
        //System.out.println(sum);
        sum=Math.abs(sum);
        
        return (int)(sum/limit)+(int)(sum % limit==0?0:1);
    }
}