class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int len=nums.length;
        int[] res=new int[k];
        Stack<Integer> stack=new Stack();
        
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && stack.peek()>nums[i] && stack.size()-1+len-i>=k)
                stack.pop();
            if(stack.size()<k)
                stack.push(nums[i]);
        }
        
        int itr=k-1;
        while(itr>=0)
            res[itr--]=stack.pop();
        return res;
    }
    
}
