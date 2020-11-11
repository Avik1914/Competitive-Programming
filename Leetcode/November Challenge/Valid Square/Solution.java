/*
Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.

Example:

Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True
 

Note:

All the input integers are in the range [-10000, 10000].
A valid square has four equal sides with positive length and four equal angles (90-degree angles).
Input points have no order.
*/

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] sq=new int[4][2];
        sq[0]=p1;
        sq[1]=p2;
        sq[2]=p3;
        sq[3]=p4;
        Map<Integer,Integer> map=new HashMap();
        
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i!=j){
                    int val=(sq[i][0]-sq[j][0])*(sq[i][0]-sq[j][0])
                                +(sq[i][1]-sq[j][1])*(sq[i][1]-sq[j][1]);
                    map.put(val,map.getOrDefault(val,0)+1);
                }
            }
        }
        
        if(map.size()!=2)
            return false;
        int a=-1;int b=-1;
        for(int i:map.keySet()){
            
            if(map.get(i)!=8 && map.get(i)!=4 )
                return false;
            if(map.get(i)==8)
                a=i;
            else
                b=i;
                
        }
        return b/2==a;
    }
}
