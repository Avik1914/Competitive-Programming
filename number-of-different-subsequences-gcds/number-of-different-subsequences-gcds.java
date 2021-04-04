class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int[] factor=new int[200001];
        
        for(int i=0;i<nums.length;i++){
            for(int j=1;j*j<=nums[i];j++){
                if(nums[i]%j==0){
                    int a=nums[i]/j;
                    int b=j;
                    if(factor[a]==0)
                        factor[a]=nums[i];
                    else
                        factor[a]=gcd(factor[a],nums[i]);        
                    if(factor[b]==0)
                        factor[b]=nums[i];
                    else
                        factor[b]=gcd(factor[b],nums[i]);
                }
            }
        }
        
        int ans=0;
        for(int i=1;i<200001;i++){
            if(factor[i]==i)
                ans++;
        }
        return ans;
    }
    
    
    public int gcd(int a,int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}