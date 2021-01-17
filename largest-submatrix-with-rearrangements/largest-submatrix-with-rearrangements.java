class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        int[][] lkp=new int[r][c];
        
        for(int i=0;i<c;i++){
            int sum=0;
            for(int j=0;j<r;j++){
                if(matrix[j][i]==0)
                    sum=0;
                else
                    sum+=matrix[j][i];
                lkp[j][i]=sum;
            }
        }
        int res=0;
        for(int i=0;i<r;i++){
            int[] val=lkp[i];
            Arrays.sort(val);
            for(int j=0;j<c;j++){
                
                if(val[j]==0)
                    continue;
                res=Math.max(res,val[j]*(c-j));
            }
        }
        
        return res;
    
    }
}
