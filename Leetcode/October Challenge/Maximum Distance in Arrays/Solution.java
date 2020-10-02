/*
Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.

Example 1:

Input: 
[[1,2,3],
 [4,5],
 [1,2,3]]
Output: 4
Explanation: 
One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
Note:

Each given array will have at least 1 number. There will be at least two non-empty arrays.
The total number of the integers in all the m arrays will be in the range of [2, 10000].
The integers in the m arrays will be in the range of [-10000, 10000].
*/

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int size=arrays.size();
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int ind1=-1,ind2=-1,ind3=-1,ind4=-1;
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        
        for(int i=0;i<size;i++){
            int locSize=arrays.get(i).size();
            if(max1<=arrays.get(i).get(locSize-1)){
                max2=max1;
                ind2=ind1;
                max1=arrays.get(i).get(locSize-1);
                ind1=i;
            }
            else if(max2<arrays.get(i).get(locSize-1)){
                max2=arrays.get(i).get(locSize-1);
                ind2=i;
            }
            
            if(min1>=arrays.get(i).get(0)){
                min2=min1;
                ind4=ind3;
                min1=arrays.get(i).get(0);
                ind3=i;
            }
            else if(min2>arrays.get(i).get(0)){
                min2=arrays.get(i).get(0);
                ind4=i;
            }
        }
        int res=0;
        if(ind1!=ind3)
            return max1-min1;
        else{
            return Math.max(Math.abs(max1-min2),Math.abs(max2-min1));
        }
    }
}
