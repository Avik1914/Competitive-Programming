class Solution {
    
    public int constrainedSubsetSum(int[] nums, int k) {
        int len=nums.length;
        int res=Integer.MIN_VALUE;
        
        
        
        
        Deque<int[]> deque=new LinkedList<>();
        int sum=0;
        
        for(int i=0;i<len;i++){
            
           if(!deque.isEmpty() && i-deque.peekFirst()[0]>k)
              deque.pollFirst();
            
           sum=Math.max(nums[i],nums[i]+(deque.isEmpty()?0:deque.peekFirst()[1]));
            
           while(!deque.isEmpty() && sum>=deque.peekLast()[1])
               deque.pollLast();
            deque.add(new int[]{i,sum});
            res=Math.max(res,sum);
            
        }
        
        
        /*int[] dp=new int[len];
        dp[len-1]=nums[len-1];
        
        
        
        for(int i=len-2;i>=0;i--){
            dp[i]=nums[i];
            int max=dp[i];
            for(int j=i+1;j<Math.min(len,i+k+1);j++)
                max=Math.max(max,dp[i]+dp[j]);
            res=Math.max(max,res);
            dp[i]=max;
        }*/
        
        return res;
    }
    
}