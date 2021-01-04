class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
       int len=nums.length;
        int[] dp=new int[len];
        int res=nums[len-1];
        Deque<Integer> deque = new LinkedList<Integer>(); 
        deque.add(len-1);
        dp[len-1]=res;
        
        for(int i=len-2;i>=0;i--){
            if(!deque.isEmpty() && deque.getLast()-i>k)
                deque.removeLast();
            int val=deque.isEmpty()?0:dp[deque.getLast()];
            dp[i]=Math.max(nums[i],nums[i]+val);
            
            
            res=Math.max(res,dp[i]);
            
            while(!deque.isEmpty() && dp[deque.getFirst()]<dp[i])
                deque.removeFirst();
            deque.addFirst(i);
        }
        
        return res;
    }
}
