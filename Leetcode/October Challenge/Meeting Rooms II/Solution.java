/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/


class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int len=intervals.length;
        int[] in=new int[len];
        int[] out=new int[len];
        
        for(int i=0;i<len;i++){
            in[i]=intervals[i][0];
            out[i]=intervals[i][1];
        }
        Arrays.sort(in);
        Arrays.sort(out);
        int i=0,j=0,res=0;
        
        while(i<len || j<len){
            if(i<len && in[i]<out[j])
                i++;
            else
                j++;
            res=Math.max(res,i-j);
        }
        return res;
    }
}
