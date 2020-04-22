/*
You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.

 

Example 1:

Input: [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].
 

Note:

The given list may contain duplicates, so ascending order means >= here.
1 <= k <= 3500
-105 <= value of elements <= 105.
*/

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int itr=0;
        List<int[]> lkp=new ArrayList();
        int k=nums.size();
        int[] track=new int[k];
        for(List<Integer> li:nums){
            for(int i:li)
                pq.add(new int[]{i,itr});
            itr++;
        }
        int count=0;
        int start=0;
        int res[]=new int[]{0,100000000};
        
        while(!pq.isEmpty()){
            int[] val=pq.poll();
            lkp.add(val);
            if(track[val[1]]==0)
                count++;
            track[val[1]]++;
            
            while(track[lkp.get(start)[1]]>1){
                track[lkp.get(start)[1]]--;
                start++;
            }
            if(count==k){
                if((res[1]-res[0])>(val[0]-lkp.get(start)[0])){
                    res[0]=lkp.get(start)[0];
                    res[1]=val[0];
                }
            }
        }
        return res;
    }
}
