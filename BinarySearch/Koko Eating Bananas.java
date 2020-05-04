/*
Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.

Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.

Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.

Return the minimum integer K such that she can eat all the bananas within H hours.

 

Example 1:

Input: piles = [3,6,7,11], H = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], H = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], H = 6
Output: 23
 

Note:

1 <= piles.length <= 10^4
piles.length <= H <= 10^9
1 <= piles[i] <= 10^9
*/

class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int len=piles.length;
        int hi=0;
        for(int p:piles)
            hi=Math.max(p,hi);
        
        int lo=1;
        
        while(lo<hi){
            int mid=lo+((hi-lo)>>1);
            int req=0;
            
            for(int i=0;i<len;i++)
                req+=(piles[i]+mid-1)/mid;
            
            if(req>H)
                lo=mid+1;
            else
                hi=mid;
        }
        return lo;
    }
}
