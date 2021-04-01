class Solution {
    int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    Integer[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int max=0;
        dp=new Integer[row][col];
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                max=Math.max(dfs(matrix,i,j,Integer.MIN_VALUE),max);
            }
        }
        
        return max;
        
    }
    
    public int dfs(int[][] matrix,int r,int c,int prev){
        if(r>=matrix.length || c>=matrix[0].length || c<0 || r<0 || matrix[r][c]<=prev)
            return 0;
        if(dp[r][c]!=null)
            return dp[r][c];
        int max=0;
        for(int[] d:dir)
            max=Math.max(max,1+dfs(matrix,r+d[0],c+d[1],matrix[r][c]));
        dp[r][c]=max;
        return max;
        
    }
    
    
}