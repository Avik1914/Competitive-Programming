/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mArr) {
        int len=mArr.length();
        int lo=0,hi=len-1;
        
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if(mArr.get(mid)<mArr.get(mid+1))
                lo=mid+1;
            else
                hi=mid;
        }
        
        int ind=len;
        
        int peak=lo;
        lo=0;hi=peak-1;
        
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if(mArr.get(mid)<target)
                lo=mid+1;
            else
                hi=mid;
        }
        if(mArr.get(lo)==target)
            return lo;
        
        lo=peak;hi=len-1;
        while(lo<hi){
            int mid=lo+(hi-lo)/2+1;
            if(mArr.get(mid)<target)
                hi=mid-1;
            else
                lo=mid;
        }
        if(mArr.get(lo)==target)
            return lo;
        return -1;
    }
}