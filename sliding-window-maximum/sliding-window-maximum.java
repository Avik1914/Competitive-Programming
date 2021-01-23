class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque=new LinkedList();
        int len=nums.length;
        int[] res=new int[len-k+1];
        int itr=0;
        
        for(int i=0;i<len;i++){
            while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()])
                deque.removeLast();
            if(!deque.isEmpty() && i-deque.peekFirst()>=k)
                deque.removeFirst();
            deque.addLast(i);
            if(i+1>=k)
                res[itr++]=nums[deque.peekFirst()];
           
        }
        
        return res;
    }
}
