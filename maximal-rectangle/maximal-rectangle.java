class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row=matrix.length;
        if(row==0)
            return 0;
        int col=matrix[0].length;
        int[] dp=new int[col];
        int res=0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='1')
                    dp[j]+=1;
                else
                    dp[j]=0;
            }
            res=Math.max(res,calculateRectangle(dp));
        }
        return res;
    }
    
    public int calculateRectangle(int[] heights){
        int len=heights.length;
        int[] lessFromLeft=new int[len];
        int[] lessFromRight=new int[len];
        
        lessFromLeft[0]=-1;
        lessFromRight[len-1]=len;
        
        for(int i=1;i<len;i++){
            int p=i-1;
            while(p>=0 && heights[p]>=heights[i])
                p=lessFromLeft[p];
            lessFromLeft[i]=p;
        }
        
        for(int i=len-2;i>=0;i--){
            int p=i+1;
            while(p<len && heights[p]>=heights[i]){
                p=lessFromRight[p];
            }
            lessFromRight[i]=p;
        }
        int res=0;
        for(int i=0;i<len;i++){
            res=Math.max(res,heights[i]*(lessFromRight[i]-lessFromLeft[i]-1));
        }
        return res;
    }
}