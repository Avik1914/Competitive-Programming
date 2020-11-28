class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<Integer>(); 
        int[] res=new int[nums.length-k+1];
        int itr=0;
        for(int i=0;i<nums.length;i++){
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i])
                deque.pollLast();
            while(!deque.isEmpty() && i-deque.peekFirst()>=k)
                deque.pollFirst();
            deque.addLast(i);
            if(i>=k-1)
                res[itr++]=nums[deque.peekFirst()];
        }
        return res;
    }
}
