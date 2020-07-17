/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.
*/
/* Min heap Solution */ 
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len=nums.length;
        Map<Integer,Integer> map=new HashMap();
        for(int n:nums)
            map.put(n,map.getOrDefault(n,0)+1);
        
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int n:map.keySet()){
            pq.add(n);
            if(pq.size()>k)
                pq.poll();
        }
        
        int[] res=new int[k];
        
        
        for(int i=k-1;i>=0;i--)
            res[i]=pq.poll();
        
        return res;
    }
}

/*Bucket Sort*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         Map<Integer,Integer> map=new HashMap();
         List<Integer>[] buckets=new ArrayList[nums.length+1];
        for(int n:nums)
            map.put(n,map.getOrDefault(n,0)+1);
        
        for(int n:map.keySet()){
            int val=map.get(n);
            if(buckets[val]==null)
                buckets[val]=new ArrayList();
            buckets[val].add(n);
        }
        int[] res=new int[k];
        int itr=0;
        for(int i=nums.length;i>=1;i--){
            if(buckets[i]!=null){
                for(int val:buckets[i]){
                    res[itr++]=val;
                    if(itr==k)
                        return res;
                }
            }
        }
        return res;
    }
}

