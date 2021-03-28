class Solution {
    int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0) 
                   && dfs(board,word.toCharArray(),0,i,j,new boolean[board.length][board[0].length]))
                    return true;
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] b,char[] w,int start,int i,int j,boolean[][] visit){
        if(start>=w.length)
            return true;
        if(i<0 || i>=b.length || j<0 || j>=b[0].length || visit[i][j] || b[i][j]!=w[start])
            return false;
        visit[i][j]=true;
        for(int[] d:dir){
            if(dfs(b,w,start+1,i+d[0],j+d[1],visit))
                return true;
        }
        visit[i][j]=false;
        return false;
    }
}