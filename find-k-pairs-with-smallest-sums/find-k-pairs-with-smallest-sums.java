class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len=nums1.length;
        int len1=nums2.length;
        
        List<List<Integer>> res=new ArrayList();
        if(len==0 || len1==0)
            return res;
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->(nums1[a[0]]+nums2[a[1]])-(nums1[b[0]]+nums2[b[1]]));
        
        for(int i=0;i<k && i<len;i++)
            pq.add(new int[]{i,0});
        
        while(k-->0 && !pq.isEmpty()){
            int[] val=pq.poll();
            List<Integer> temp=new ArrayList();
            temp.add(nums1[val[0]]);
            temp.add(nums2[val[1]]);
            res.add(temp);
            if(val[1]+1<nums2.length){
                val[1]++;
                pq.add(val);
            }
        }
        
        return res;
    }
}