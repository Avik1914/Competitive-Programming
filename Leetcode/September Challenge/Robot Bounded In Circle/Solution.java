/*
On an infinite plane, a robot initially stands at (0, 0) and faces north.  The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degress to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

 

Example 1:

Input: "GGLLGG"
Output: true
Explanation: 
The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
Example 2:

Input: "GG"
Output: false
Explanation: 
The robot moves north indefinitely.
Example 3:

Input: "GL"
Output: true
Explanation: 
The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 

Note:

1 <= instructions.length <= 100
instructions[i] is in {'G', 'L', 'R'}
*/

class Solution {
    public boolean isRobotBounded(String instructions) {
        char[] arr=instructions.toCharArray();
        Map<Integer,int[]> map=new HashMap();
        map.put(0,new int[]{1,0});
        map.put(90,new int[]{0,-1});
        map.put(180,new int[]{-1,0});
        map.put(270,new int[]{0,1});
        int x=0,y=0;
        int pres=0;
        for(char c:arr){
            if(c=='L')
                pres+=90;
            else if(c=='R')
                pres+=270;
            else{
                x+=map.get(pres)[0];
                y+=map.get(pres)[1];
            }
            pres%=360;
        }
        
        if(x==0 && y==0)
            return true;
        return pres!=0;
    }
}
