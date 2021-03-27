class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        int pres=1;
        int x=0,y=0;
        
        for(char c:instructions.toCharArray()){
            if(c=='G'){
                x+=dir[pres][0];
                y+=dir[pres][1];
            }else if(c=='L')
                pres--;
            else
                pres++;
            pres+=4;
            pres%=4;
        }
        return (x==0 && y==0) || pres!=1;
    }
}