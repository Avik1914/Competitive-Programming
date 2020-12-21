class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<int[]> deque = new LinkedList<int[]>(); 
        int sum=nums[0];
        int hi=nums[0];
        int len=nums.length;
        deque.add(new int[]{0,nums[0]});
        int val=hi;
        for(int i=1;i<len;i++){
            val=nums[i]+deque.getFirst()[1];
            while(!deque.isEmpty() && deque.getLast()[1]<=val)
                deque.removeLast();
            deque.add(new int[]{i,val});
            if(!deque.isEmpty() && deque.getLast()[0]-deque.getFirst()[0]==k)
                deque.removeFirst();
        }
        return val;
    }
}
