class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int len=nums.length;
        int res=0;
        int start=0;
        PriorityQueue<Integer> pqMax=new PriorityQueue<>((a,b)->nums[b]-nums[a]);
        PriorityQueue<Integer> pqMin=new PriorityQueue<>((a,b)->nums[a]-nums[b]);
        
        for(int i=0;i<len;i++){
            pqMax.add(i);
            pqMin.add(i);
            while(!pqMax.isEmpty() && pqMax.peek()<start)
                pqMax.poll();
            while(!pqMin.isEmpty() && pqMin.peek()<start)
                pqMin.poll();
            while(!pqMax.isEmpty() && !pqMin.isEmpty() && nums[pqMax.peek()]-nums[pqMin.peek()]>limit){
                if(pqMax.peek()<pqMin.peek())
                    start=pqMax.poll()+1;
                else
                    start=pqMin.poll()+1;
                 while(!pqMax.isEmpty() && pqMax.peek()<start)
                    pqMax.poll();
                 while(!pqMin.isEmpty() && pqMin.peek()<start)
                    pqMin.poll();
            }
            res=Math.max(res,i-start+1);
            
        }
        
        return res;
    }
}