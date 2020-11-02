/*
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true
 

Constraints:

0 <= intervals.length <= 104
intervals.length == 2
0 <= starti < endi <= 106
*/

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int prev=-1;
        for(int[] i:intervals){
            if(i[0]<prev)
                return false;
            prev=i[1];
        }
        return true;
    }
}
