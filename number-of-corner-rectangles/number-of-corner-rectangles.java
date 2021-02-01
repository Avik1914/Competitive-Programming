class Solution {
    public int countCornerRectangles(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        
        int[][] dp=new int[col+1][col+1];
        int res=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for(int k=j+1;k<col;k++){
                        if(grid[i][j]==1 && grid[i][k]==1){
                            dp[j+1][k+1]+=1;
                            res+=dp[j+1][k+1]-1;
                        }   
                }
                
            }
        }
        
        return res;
    }
}