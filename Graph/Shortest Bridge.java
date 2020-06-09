/*
In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

 

Example 1:

Input: A = [[0,1],[1,0]]
Output: 1
Example 2:

Input: A = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 

Constraints:

2 <= A.length == A[0].length <= 100
A[i][j] == 0 or A[i][j] == 1
*/

class Solution {
    public int shortestBridge(int[][] A) {
     int r=A.length;
     if(r==0)
         return 0;
     int c=A[0].length;
        
     int[][] visit=new int[r][c];
     int[][] dir=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
     int val=1,size=0,res=0;
     Queue<int[]> queue=new LinkedList();
     
        
     for(int i=0;i<r;i++){
         for(int j=0;j<c;j++){
             if(A[i][j]==1 && val==1){
                 dfs(A,i,j,dir,visit);
                 val++;
             }else if(A[i][j]==1 && visit[i][j]==0)
                 queue.add(new int[]{i,j});
         }   
     }
     while(!queue.isEmpty()){
         size=queue.size();
         while(size-->0){
             int[] temp=queue.poll();
             for(int[] d:dir){
                 int nr=d[0]+temp[0];
                 int nc=d[1]+temp[1];
                 if(nr<r && nc<c && nr>=0 && nc>=0){
                     if(visit[nr][nc]==1)
                         return res;
                     if(A[nr][nc]==0 && visit[nr][nc]==0){
                         queue.add(new int[]{nr,nc});
                         visit[nr][nc]=2;
                     }
                 }
             }
         }
         res++;
     }
     return res;
    }
    
    public void dfs(int[][] A,int r,int c,int[][] dir,int[][] visit){
        if(r>=A.length || c>=A[0].length || r<0 || c<0 || visit[r][c]==1
          || A[r][c]==0)
            return;
        visit[r][c]=1;
        for(int[] d:dir){
            dfs(A,r+d[0],c+d[1],dir,visit);
        }
    }
}
