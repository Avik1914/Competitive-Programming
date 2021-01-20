class Solution {
    public boolean splitArray(int[] nums) {
        int len=nums.length;
        int sum=0;
        
        int[] prefixSum=new int[len];
        for(int i=0;i<len;i++){
            sum+=nums[i];
            prefixSum[i]=sum;
        }
        
        for(int j=3;j<len-3;j++){
            Set<Integer> set=new HashSet();
            for(int i=1;i<j-1;i++){
                if(prefixSum[i-1]==prefixSum[j-1]-prefixSum[i])
                    set.add(prefixSum[i-1]);
            }   
            for(int k=j+2;k<len-1;k++){
                if(prefixSum[k-1]-prefixSum[j]==prefixSum[len-1]-prefixSum[k]){
                    if(set.contains(prefixSum[k-1]-prefixSum[j]))
                        return true;
                }
            }
        }
        return false;
    }
}
