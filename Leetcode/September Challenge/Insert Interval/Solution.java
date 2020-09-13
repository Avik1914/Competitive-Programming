/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len=intervals.length;
        int first=search(intervals,newInterval[0]);
        int second=search(intervals,newInterval[1]);
//        System.out.println(first+","+second);
        List<int[]> res=new ArrayList();
        
        int start=-1,end=-1;
        for(int i=0;i<len;i++){
            if(i<first || i>second){
                if(start!=-1 && end!=-1){
                    res.add(new int[]{start,end});
                    start=-1;
                }
                res.add(intervals[i]);
            }
            else {
                if(intervals[i][0]<=newInterval[0] && intervals[i][1]>=newInterval[1])
                    res.add(intervals[i]);
                else if(start==-1 && intervals[i][1]<newInterval[0]){
                    res.add(intervals[i]);
                    start=newInterval[0];
                    end=newInterval[1];
                }else if(start==-1 && intervals[i][0]>newInterval[1]){
                    res.add(newInterval);
                    res.add(intervals[i]);
                }
                else{
                    if(start==-1){
                        start=Math.min(intervals[i][0],newInterval[0]);
                        end=newInterval[1];
                    }
                    end=Math.max(intervals[i][1],end);
                     System.out.println(i+","+start+","+end);
                }
            }
        }
            if(start!=-1 && end!=-1)
                    res.add(new int[]{start,end});
        if(len==0)
            res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
    
    
    public int search(int[][] intervals,int val){
            int len=intervals.length;
            int lo=0;
            int hi=len-1;
        
            while(lo<hi){
                int mid=(hi+lo+1)>>1;
                if(intervals[mid][0]>val)
                    hi=mid-1;
                else
                    lo=mid;
            }
        return lo;
    }
}
